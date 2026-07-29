class Solution {
    static final long CAP = 2_000_000L;
    static final long INF = Long.MAX_VALUE / 4;

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;

        int[] half = new int[26];
        char middle = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) middle = (char) ('a' + i);
            half[i] = cnt[i] / 2;
        }

        int m = 0;
        for (int i = 0; i < 26; i++) m += half[i];

        if (m == 0) {
            if (k != 1) return "";
            return middle != 0 ? String.valueOf(middle) : "";
        }

        double[] logFact = new double[m + 1];
        for (int i = 1; i <= m; i++) logFact[i] = logFact[i - 1] + Math.log(i);
        double logThreshold = Math.log((double) CAP);

        double sumLogFact = 0.0;
        for (int c = 0; c < 26; c++) sumLogFact += logFact[half[c]];

        int[] cur = half.clone();
        int total = m;
        long kk = k;

        StringBuilder sb = new StringBuilder();

        for (int pos = 0; pos < m; pos++) {
            boolean placed = false;
            for (int c = 0; c < 26; c++) {
                if (cur[c] == 0) continue;
                int old = cur[c];
                double newSumLogFact = sumLogFact - logFact[old] + logFact[old - 1];
                int newTotal = total - 1;
                double logCount = logFact[newTotal] - newSumLogFact;

                long cntArr;
                if (logCount > logThreshold) {
                    cntArr = INF;
                } else {
                    cur[c] = old - 1;
                    cntArr = exactMultinomial(cur, newTotal);
                    cur[c] = old;
                }

                if (kk <= cntArr) {
                    cur[c] = old - 1;
                    total = newTotal;
                    sumLogFact = newSumLogFact;
                    sb.append((char) ('a' + c));
                    placed = true;
                    break;
                } else {
                    kk -= cntArr;
                }
            }
            if (!placed) return "";
        }

        String halfStr = sb.toString();
        StringBuilder full = new StringBuilder(halfStr);
        if (middle != 0) full.append(middle);
        full.append(new StringBuilder(halfStr).reverse());
        return full.toString();
    }

    private long exactMultinomial(int[] counts, int total) {
        long result = 1;
        int remaining = 0;
        for (int c = 0; c < 26; c++) {
            if (counts[c] == 0) continue;
            remaining += counts[c];
            result *= combExact(remaining, counts[c]);
        }
        return result;
    }

    private long combExact(int n, int r) {
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }
        return res;
    }
}