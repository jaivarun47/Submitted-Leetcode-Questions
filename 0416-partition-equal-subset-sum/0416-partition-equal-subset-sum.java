class Solution {
    public boolean subarray(int[] nums, Boolean[][] dp, int sum, int idx){
        if (sum == 0) return true;
        if (idx < 0) return false;
        if (dp[idx][sum] != null) return dp[idx][sum];
        boolean notTake = subarray(nums, dp, sum, idx-1);
        boolean take = false;
        if (nums[idx] <= sum){
            take = subarray(nums, dp, sum - nums[idx], idx-1);
        }
        return dp[idx][sum] = take || notTake;
    }
    public boolean canPartition(int[] nums){
        int sum = 0;
        for (int num:nums) sum += num;
        Boolean[][] dp = new Boolean[nums.length][sum/2 + 1];
        return (sum)%2 != 0 ? false : subarray(nums, dp, sum/2, nums.length-1);
    }   
}