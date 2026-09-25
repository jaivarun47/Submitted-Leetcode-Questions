class Solution {
    public int longestNiceSubarray(int[] nums) {

        int left = 0;
        int bits = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {

            while ((bits & nums[right]) != 0) {
                bits ^= nums[left++];
            }

            bits |= nums[right];

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}