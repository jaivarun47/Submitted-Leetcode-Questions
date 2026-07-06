class Solution {
public:
    int maxProfit(vector<int>& prices){
        int currentDiff = 0;
        int maxDiff = 0;
        for (int i = 1; i < prices.size(); i++){
            currentDiff = max((prices[i] - prices[i-1]), currentDiff + (prices[i] - prices[i-1]));
            maxDiff = max(currentDiff, maxDiff);
        }
        return maxDiff;
    }
};