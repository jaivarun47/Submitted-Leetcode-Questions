class Solution {
    public int pathSum(int[][] dp, int[][] grid, int x, int y){
        if (x < 0 || y < 0) return 1_000_000_000;
        if (x == 0 && y == 0) return grid[0][0];
        if (dp[x][y] != -1) return dp[x][y];
        int left = grid[x][y] + pathSum(dp, grid, x-1, y);
        int top = grid[x][y] + pathSum(dp, grid, x, y-1);
        return dp[x][y] = Math.min(left, top);
    }

    public int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] num: dp){
            Arrays.fill(num, -1);
        }
        return pathSum(dp, grid, grid.length-1, grid[0].length-1);
    }
}