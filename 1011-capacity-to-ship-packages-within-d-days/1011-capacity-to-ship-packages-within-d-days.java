class Solution {
    public int findMax(int[] nums){
        int max = 0;
        for (int num: nums){
            if (num > max) max = num;
        }
        return max;
    }

    public int sum(int[] nums){
        int sums = 0;
        for (int num: nums) sums += num;
        return sums;
    }

    public boolean isValid(int[] weights, int currentCapacity, int days){
        int i = 0, count = 1, currentWeight = 0;
        while (i < weights.length){
            if (currentWeight + weights[i] > currentCapacity){
                count++;
                currentWeight = weights[i];
                i++;
            } else {
                currentWeight += weights[i];
                i++;
            }
        }
        return count <= days;
    }

    public int shipWithinDays(int[] weights, int days){
        int low = findMax(weights), high = sum(weights);
        while (low < high){
            int mid = low + (high - low)/2;
            if (isValid(weights, mid, days)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}