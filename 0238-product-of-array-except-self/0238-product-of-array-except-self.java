class Solution {
    public int[] productExceptSelf(int[] nums){
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        int j = nums.length - 1;
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++){
            left *= nums[i];
            right *= nums[j];
            leftProduct[i] = left;
            rightProduct[j] = right;
            j--;
        }

        int[] selfExclusion = new int[nums.length];
        for (int i = 0; i < selfExclusion.length; i++){
            if (i == 0) selfExclusion[i] = rightProduct[i+1];
            else if (i == nums.length - 1) selfExclusion[i] = leftProduct[i-1];
            else selfExclusion[i] = leftProduct[i-1]*rightProduct[i+1];
        }

        return selfExclusion;
    }
}