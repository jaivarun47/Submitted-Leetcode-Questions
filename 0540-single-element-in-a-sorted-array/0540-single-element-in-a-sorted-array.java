class Solution {
    public int singleNonDuplicate(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = low + (high - low)/2;
            if (mid%2 == 0){
                if (nums[mid + 1] != nums[mid]){
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid-1] != nums[mid]){
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return nums[low];
    }
}