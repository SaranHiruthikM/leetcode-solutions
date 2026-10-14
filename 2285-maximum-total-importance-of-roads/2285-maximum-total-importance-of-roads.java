class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int indeg[][] = new int[n][2];
        for(int i=0; i<n; i++){
            indeg[i] = new int[]{0, i};
        }
        int imp[] = new int[n];
        for(int i=0; i<roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            indeg[u][0]++;
            indeg[v][0]++;
        }
        Arrays.sort(indeg, (a, b) -> Integer.compare(b[0], a[0]));
        int idx = 0;
        for(int i=n; i>=1; i--){
            int currIdx = indeg[idx][1];
            imp[currIdx] = i;
            idx++;
        }
        long maxImp = 0;
        for(int road[] : roads){
            int u = road[0];
            int v = road[1];
            maxImp += imp[u] + imp[v];
        }

        return maxImp;
    }
}