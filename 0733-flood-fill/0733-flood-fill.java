class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int original = image[sr][sc];
        if (original == color) return image;
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        vis[sr][sc] = true;
        image[sr][sc] = color;
        q.add(new int[]{sr, sc});

        int[][] direction = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };


        while (!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for (int[] dir: direction){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]){
                    if (image[nr][nc] == original){
                        q.add(new int[]{nr, nc});
                        image[nr][nc] = color;
                        vis[nr][nc] = true;
                    }

                }
            }
        }
        return image;
    }
}