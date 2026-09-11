class Solution {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        final int MOD = 1_000_000_007;

        long ans = (countUpTo(num2, min_sum, max_sum) 
                  - countUpTo(num1, min_sum, max_sum)) % MOD;

        if (isGood(num1, min_sum, max_sum)) {
            ans++;
        }

        return (int) ((ans + MOD) % MOD);
    }

    private long countUpTo(String s, int minSum, int maxSum) {
        int n = s.length();

        long[][][] dp = new long[n + 1][maxSum + 1][2];
        dp[0][0][1] = 1;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            for (int sum = 0; sum <= maxSum; sum++) {
                for (int tight = 0; tight <= 1; tight++) {
                    long ways = dp[i][sum][tight];

                    if (ways == 0) continue;

                    int limit = tight == 1 ? digit : 9;

                    for (int d = 0; d <= limit; d++) {
                        if (sum + d > maxSum) break;

                        int newTight = (tight == 1 && d == digit) ? 1 : 0;

                        dp[i + 1][sum + d][newTight] =
                            (dp[i + 1][sum + d][newTight] + ways)
                            % 1_000_000_007;
                    }
                }
            }
        }

        long result = 0;

        for (int sum = minSum; sum <= maxSum; sum++) {
            result = (result + dp[n][sum][0]) % 1_000_000_007;
            result = (result + dp[n][sum][1]) % 1_000_000_007;
        }

        return result;
    }

    private boolean isGood(String s, int minSum, int maxSum) {
        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += c - '0';
        }

        return sum >= minSum && sum <= maxSum;
    }
}