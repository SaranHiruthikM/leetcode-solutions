class Solution {
    void floydWarshall(int n, int[][] shortestPathMatrix) {
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    shortestPathMatrix[i][j] = Math.min(shortestPathMatrix[i][j],
                                                        shortestPathMatrix[i][via] + shortestPathMatrix[via][j]);
                }
            }
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPathMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], (int) 1e9 + 7);
            shortestPathMatrix[i][i] = 0;  // Distance to itself is zero
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            shortestPathMatrix[u][v] = wt;
            shortestPathMatrix[v][u] = wt;
        }
        floydWarshall(n, shortestPathMatrix);

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(i != j && shortestPathMatrix[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= min){
                min = cnt;
                ans = i;
            }
        }

        return ans;
    }
}