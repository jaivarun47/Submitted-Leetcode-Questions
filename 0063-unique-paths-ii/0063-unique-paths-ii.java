class Solution {
    public int possiblePath(int[][] obstacleGrid, int[][] dp, int x, int y){
        if (x < 0 || y < 0) return 0;
        if (obstacleGrid[x][y] == 1) return 0;
        if (x == 0 && y == 0) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        int left = possiblePath(obstacleGrid, dp, x-1, y);
        int top = possiblePath(obstacleGrid, dp, x, y-1);
        return dp[x][y] = left + top;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] num: dp){
            Arrays.fill(num, -1);
        }
        return possiblePath(obstacleGrid, dp, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }
    
}