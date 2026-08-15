class Solution {
    public int robberHehe(int[] dp, int[] nums, int idx, boolean robNMinusOne){
        if (robNMinusOne){
            if (idx < 1) return 0;
        } else {
            if (idx < 0) return 0;
        }
        if (dp[idx] != -1) return dp[idx];
        int left = robberHehe(dp, nums, idx-1, robNMinusOne);
        int right = nums[idx] + robberHehe(dp, nums, idx-2, robNMinusOne);
        return dp[idx] = Math.max(left, right);
    }
    public int rob(int[] nums){
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        return Math.max(robberHehe(dp, nums, nums.length - 1, true), robberHehe(dp2, nums, nums.length - 2, false));
    }
}  