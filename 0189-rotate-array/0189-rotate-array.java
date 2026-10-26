class Solution {
    public void swap(int[] nums, int low, int high){
        while (low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[] nums, int k){
        k %= nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k-1);
        swap(nums, k, nums.length - 1);
    }
}