class Solution {
    public boolean canPartition(int[] nums){
        int arrSum = 0;
        for (int num:nums) arrSum += num;
        if (arrSum%2 != 0) return false;
        int target = arrSum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
        for (int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        if (nums[0] <= target) dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++){
            for (int sum = 1; sum <= target; sum++){
                boolean notTake = dp[i-1][sum];
                boolean take = false;
                if (nums[i] <= sum){
                    take = dp[i-1][sum - nums[i]];
                }
                dp[i][sum] = take || notTake;
            }
            if (dp[i][target]) return true;
        }
        return false;
    } 
}