class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negatives = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    negatives++;
                }

                int abs = Math.abs(num);
                sum += abs;
                minAbs = Math.min(minAbs, abs);
            }
        }

        if (negatives % 2 == 1) {
            sum -= 2L * minAbs;
        }

        return sum;
    }
}