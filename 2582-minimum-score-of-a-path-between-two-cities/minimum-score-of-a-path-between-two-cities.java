class Solution {
    HashMap<Integer, List<int[]>> adj = new HashMap<>();
    int result = Integer.MAX_VALUE;
    private void dfs(int src, boolean[] vis){
        vis[src] = true;
        for(int v[] : adj.getOrDefault(src, new ArrayList<>())){
            result = Math.min(result, v[1]);
            if(!vis[v[0]]){
                dfs(v[0], vis);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        
        for(int road[] : roads){
            adj.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            adj.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        boolean visited[] = new boolean[n+1];

        dfs(1, visited);

        return result;
        
    }
}