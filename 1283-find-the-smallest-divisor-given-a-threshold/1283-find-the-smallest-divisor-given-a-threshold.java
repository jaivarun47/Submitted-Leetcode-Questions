class Solution {
    public int findMax(int[] nums){
        int max = 0;
        for (int num: nums){
            if (num > max) max = num;
        }
        return max;
    }

    public boolean isValid(int[] nums, int divisor, int threshold){
        int quotient = 0;
        for (int num: nums){
            quotient += (num + divisor - 1)/divisor;
        }
        return quotient <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold){
        int low = 1, high = findMax(nums);
        while (low < high){
            int mid = low + (high - low)/2;
            if (isValid(nums, mid, threshold)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}