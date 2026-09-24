import java.util.*;

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        int[] dp = new int[k + 1];

        for (List<Integer> pile : piles) {
            int n = pile.size();
            int[] sum = new int[n + 1];

            for (int i = 0; i < n; i++)
                sum[i + 1] = sum[i] + pile.get(i);


            for (int coins = k; coins >= 0; coins--) {

                for (int take = 1; take <= Math.min(n, coins); take++) {
                    dp[coins] = Math.max(dp[coins],
                            dp[coins - take] + sum[take]);
                }
            }
        }

        return dp[k];
    }
}