class Solution {
    public void rotate(int[] nums, int k){
        int[] numsx = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            numsx[(i+k)%nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] = numsx[i];
        }
    }
}