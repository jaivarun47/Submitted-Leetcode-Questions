class Solution {
    public int majorityElement(int[] nums){
        int currNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == currNum){
                count++;
            } else {
                count--;
            }
            if (count == 0){
                currNum = nums[i];
                count = 1;
            }
        }
            return currNum;
    }
}