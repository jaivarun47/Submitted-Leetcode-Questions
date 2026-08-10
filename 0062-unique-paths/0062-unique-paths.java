class Solution {
    public int pathLength(int[][] dp, int m, int n, int x, int y){
        if (x < 0 || y < 0) return 0;
        if (x == 0 && y == 0) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        return dp[x][y] = pathLength(dp, m, n, x - 1, y) + pathLength(dp, m, n, x, y - 1);
    }
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int[] num: dp){
            Arrays.fill(num, -1);
        }
        return pathLength(dp, m, n, m-1, n-1);
    }
}