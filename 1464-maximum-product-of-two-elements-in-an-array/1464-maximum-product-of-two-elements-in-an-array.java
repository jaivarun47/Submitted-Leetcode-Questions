class Solution {
    public int maxProduct(int[] nums){
        int large = 0, larger = 0, i = 0;
        while (i < nums.length){
            if (nums[i] > large){
                large = nums[i];
            }
            if (nums[i] > larger){
                large = larger;
                larger = nums[i];
            }
            i++;
        }
        return (large-1)*(larger-1);
    }
}