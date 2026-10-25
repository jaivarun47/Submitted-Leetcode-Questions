class Solution {
    public int maxProfit(int[] prices){
        int max = 0;
        int currentProfit = 0;

        for (int i = 1; i < prices.length; i++){
            currentProfit = Math.max(currentProfit + (prices[i] - prices[i-1]), 0);
            if (currentProfit < 0) currentProfit = 0;
            max = Math.max(currentProfit, max);
        }

        return max;
    }
}