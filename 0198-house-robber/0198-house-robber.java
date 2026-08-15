class Solution {
    public int robbery(int[] dp, int[] nums, int idx){
        if (idx < 0){
            return 0;
        }

        if (dp[idx] != -1) return dp[idx];

        return dp[idx] = Math.max(robbery(dp, nums, idx - 1), nums[idx] + robbery(dp, nums, idx - 2));
    }

    public int rob(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robbery(dp, nums, nums.length-1);
    }
}