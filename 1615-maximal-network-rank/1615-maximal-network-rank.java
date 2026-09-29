class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        int indeg[] = new int[n];
        for(int road[] : roads){
            int u = road[0];
            int v = road[1];
            adj.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            adj.computeIfAbsent(v, k -> new HashSet<>()).add(u);
            indeg[u]++;
            indeg[v]++;
        }

        int maximalRank = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int isConn = 0;
                if(adj.getOrDefault(i, new HashSet<>()).contains(j)) isConn = -1;
                maximalRank = Math.max(maximalRank, indeg[i] + indeg[j] + isConn);
            }
        }

        return maximalRank;
    }
}