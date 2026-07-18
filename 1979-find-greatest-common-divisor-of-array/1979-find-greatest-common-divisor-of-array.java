class Solution {
    public int[] minMax(int[] nums){
        int min = nums[0], max = nums[0], i = 0;
        while (i < nums.length){
            if (nums[i] < min){
                min = nums[i];
                i++;
            } else if (nums[i] > max){
                max = nums[i];
                i++;
            } else {
                i++;
            }
        }
        return new int[]{min, max};
    }

    public int findGCD(int[] nums){
        int[] minMax = minMax(nums);
        int min = minMax[0], max = minMax[1];
        if (max == 0){
            return min;
        } else {
            while (max != 0){
                int temp = max;
                max = min%max;
                min = temp;
            }
        }
        return min;
    }
}