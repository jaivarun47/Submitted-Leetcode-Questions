class Solution {
    public void dfs(int[][] isConnected, int node, boolean[] vis){
        vis[node] = true;

        for (int i = 0; i < isConnected.length; i++){
            if (isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected, i, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected){
        boolean[] vis = new boolean[isConnected.length];
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++){
            if (!vis[i]){
                provinces++;
                dfs(isConnected, i, vis);
            }
        }
        return provinces;
    }
    
}