class Solution {
    public int lowerBound(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int currentLowerBound = nums.length;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] >= target){
                currentLowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (currentLowerBound == nums.length) return -1;
        return nums[currentLowerBound] == target ? currentLowerBound : -1;
    }

    public int upperBound(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int currentUpperBound = nums.length;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] > target){
                currentUpperBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return currentUpperBound;
    }

    public int[] searchRange(int[] nums, int target){
        if (nums.length == 0) return new int[]{-1,-1};
        int first = lowerBound(nums, target);
        if (first == -1)
            return new int[]{-1, -1};
        int last = upperBound(nums, target);

        return new int[]{first, last - 1};
    }
}