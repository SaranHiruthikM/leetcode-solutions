class Solution {
    private boolean dfs(HashMap<Integer, List<Integer>> adj, boolean[] vis, int source, int destination){
        vis[source] = true;
        for(int v : adj.get(source)){
            if(v == destination){
                return true;
            }
            if(!vis[v]){
                if(dfs(adj, vis, v, destination)){
                    return true;
                }
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if((edges.length == 0 || edges.length == 1) && source == destination){
            return true;
        }
        boolean vis[] = new boolean[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return dfs(adj, vis, source, destination);
    }
}