class Solution {
    boolean inRecursion[];
    boolean vis[];
    int count[];
    int result = -1;

    private void dfs(int curr, int[] edges){
        if(curr != -1){
            vis[curr] = true;
            inRecursion[curr] = true;

            int v = edges[curr];

            if(v != -1 && !vis[v]){
                count[v] = count[curr] + 1;
                dfs(v, edges);
            }else if( v != -1 && inRecursion[v]){
                result = Math.max(result, count[curr] - count[v] + 1);
            }

            inRecursion[curr] = false;
        }
    }
    public int longestCycle(int[] edges) {
        inRecursion = new boolean[edges.length];
        vis = new boolean[edges.length];
        count = new int[edges.length];

        for(int i=0; i<edges.length; i++){
            if(!vis[i]){
                dfs(i, edges);
            }
        }

        return result;
    }
}