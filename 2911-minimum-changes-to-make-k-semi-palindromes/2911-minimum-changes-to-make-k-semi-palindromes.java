import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();

        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                int minChanges = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;
                    int groupSize = len / d;

                    for (int offset = 0; offset < d; offset++) {
                        int left = 0;
                        int right = groupSize - 1;

                        while (left < right) {
                            int i = start + offset + left * d;
                            int j = start + offset + right * d;

                            if (chars[i] != chars[j]) {
                                changes++;
                            }

                            left++;
                            right--;
                        }
                    }

                    minChanges = Math.min(minChanges, changes);
                }

                cost[start][start + len - 1] = minChanges;
            }
        }

        int INF = 1_000_000_000;
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int end = 2 * parts; end <= n; end++) {
                for (int start = 2 * (parts - 1);
                     start <= end - 2; start++) {

                    if (dp[parts - 1][start] == INF) continue;

                    dp[parts][end] = Math.min(
                        dp[parts][end],
                        dp[parts - 1][start] + cost[start][end - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}