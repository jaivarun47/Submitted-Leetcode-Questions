class Solution {
    public int[] findErrorNums(int[] nums){
        int[] heap = new int[nums.length + 1];
        for (int j : nums) {
            heap[j]++;
        }
        int a = 0;
        int b = 0;
        for (int i = 1; i <= nums.length; i++){
            if (heap[i] == 2){
                a = i;
            }
            if (heap[i] == 0){
                b = i;
            }
        }
        return new int[]{a, b};
    }
}