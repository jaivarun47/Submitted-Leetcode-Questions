class Solution {
    public int robberHehe(int[] dp, int[] nums, int idx){
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];
        int left =  robberHehe(dp, nums, idx-1);
        int right = nums[idx] + robberHehe(dp, nums, idx-2);
        return dp[idx] = Math.max(left, right);            
    }

    public int rob(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robberHehe(dp, nums, nums.length - 1);
    }
}