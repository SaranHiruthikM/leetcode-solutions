class Solution {
    
    public void dfs(int node, boolean[] vis, int[][] isConnected){
        vis[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(i, vis, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean vis[] = new boolean[V];
        int cnt = 0;
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, isConnected);
                cnt++;
            }
        }

        return cnt;
    }
}