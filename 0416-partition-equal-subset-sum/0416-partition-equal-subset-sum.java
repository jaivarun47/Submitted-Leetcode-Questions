class Solution {
    public boolean partition(int[] nums, Boolean[][] dp, int idx, int sum){
        if (idx < 0 || sum < 0) return false;
        if (sum == 0) return true;
        if (dp[idx][sum] != null) return dp[idx][sum];
        boolean take = partition(nums, dp, idx - 1, sum - nums[idx]);
        boolean notTake = partition(nums, dp, idx-1, sum);
        return dp[idx][sum] = take || notTake;
    }

    public boolean canPartition(int[] nums){
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum%2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length][sum/2 + 1];
        return partition(nums, dp, nums.length - 1, sum/2);
    }
}