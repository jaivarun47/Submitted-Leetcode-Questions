class Solution {
    public int[] runningSum(int[] nums){
        int[] nums2 = new int[nums.length];
        int x = 0;
        for (int i = 0; i < nums.length; i++){
            x += nums[i];
            nums2[i] = x;
        }
        return nums2;
    }
}