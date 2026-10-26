class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                long sum = 0;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i, j});

                sum += grid[i][j];
                grid[i][j] = 0;

                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();

                    for (int[] dir : directions) {
                        int x = cell[0] + dir[0];
                        int y = cell[1] + dir[1];

                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0) {
                            sum += grid[x][y];
                            grid[x][y] = 0;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}