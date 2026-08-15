class Solution {
    public int path(int[][] obstacleGrid, int[][] dp, int x, int y){
        if (x < 0 || y < 0) return 0;
        if (obstacleGrid[x][y] == 1) return 0;
        if (x == 0 && y == 0) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        return dp[x][y] = path(obstacleGrid, dp, x-1, y) + path(obstacleGrid, dp, x, y-1);

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int[] num: dp){
            Arrays.fill(num, -1);
        }
        return path(obstacleGrid, dp, n-1, m-1);
    }
}