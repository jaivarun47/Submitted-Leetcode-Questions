class Solution {
    public int maxPile(int[] piles){
        int max = 0;
        for (int pile: piles){
            if (pile > max) max = pile;
        }
        return max;
    }

    public long hForK(int[] piles, int k){
        long sum = 0;
        for (int pile: piles){
            sum += (pile + k - 1)/k;
        }
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h){
        int low = 1, high = maxPile(piles);
        while (low <= high){
            int mid = low + (high - low)/2;
            long target = hForK(piles, mid);
            if (target <= h){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}