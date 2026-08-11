class Solution {
    public int orangesRotting(int[][] grid){
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        List<int[]> rotten = new ArrayList<>();
        int fresh = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    fresh++;
                } else if (grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int[] i: rotten){
            q.add(i);
            vis[i[0]][i[1]] = true;
        }

        int[][] direction = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        int minutes = 0;

        while (!q.isEmpty() && fresh > 0){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for (int[] dir: direction){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]){
                        if (grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            fresh--;
                            vis[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes: -1;
    }
}