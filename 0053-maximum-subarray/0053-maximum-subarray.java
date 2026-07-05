class Solution {
    public int maxSubArray(int[] nums){
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int num:nums){
            curr_sum += num;
            max_sum = Math.max(curr_sum, max_sum);
            if (curr_sum < 0) curr_sum = 0;
        }
        return max_sum;
    }
}