class Solution {
    public int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums){
        int[] prefixSum = new int[nums.length];
        int currentMax = nums[0];
        prefixSum[0] = currentMax;
        for (int i = 1; i < nums.length; i++){
            currentMax = Math.max(currentMax, nums[i]);
            prefixSum[i] = gcd(currentMax, nums[i]);
        }
        Arrays.sort(prefixSum);
        long sum = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            sum += gcd(prefixSum[low], prefixSum[high]);
            low++;
            high--;
        }
        return sum;
    }
}