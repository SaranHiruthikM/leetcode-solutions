class Solution {
    public void dfs(int[][] stones, int node, boolean[] vis){
        vis[node] = true;
        for(int i=0; i<stones.length; i++){
            int row = stones[node][0];
            int col = stones[node][1];

            if((stones[i][0] == row || stones[i][1] == col) && !vis[i]){
                dfs(stones, i, vis);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean vis[] = new boolean[n];
        int grp = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(stones, i, vis);
                grp++;
            }
        }

        return n - grp;
        
    }
}