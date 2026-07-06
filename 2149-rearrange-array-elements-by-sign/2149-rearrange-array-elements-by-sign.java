class Solution {
    public int[] rearrangeArray(int[] nums){
        int[] p = new int[nums.length/2];
        int[] n = new int[nums.length/2];
        int x = 0, y = 0;
        for (int num: nums){
            if (num >= 0){
                p[x] = num;
                x++;
            } else {
                n[y] = num;
                y++;
            }
        }
        x = 0;
        y = 0;

        for (int z = 0; z < nums.length; z++) {
            if (z % 2 == 0)
                nums[z] = p[x++];
            else
                nums[z] = n[y++];
        }
        return nums;
    }
}