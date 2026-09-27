class Solution {
    public boolean canSortArray(int[] nums) {

        int n = nums.length;
        int i = 0;

        while (i < n) {
            int bits = Integer.bitCount(nums[i]);
            int j = i;

            while (j < n && Integer.bitCount(nums[j]) == bits) {
                j++;
            }

            for (int a = i; a < j; a++) {
                for (int b = a + 1; b < j; b++) {
                    if (nums[a] > nums[b]) {
                        int temp = nums[a];
                        nums[a] = nums[b];
                        nums[b] = temp;
                    }
                }
            }

            i = j;
        }

        for (i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1])
                return false;
        }

        return true;
    }
}