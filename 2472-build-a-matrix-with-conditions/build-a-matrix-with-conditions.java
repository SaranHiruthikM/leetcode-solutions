class Solution {
    private int[] topoSort(int[][] conditions, int k){
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indeg = new int[k+1];
        for(int i=0; i<conditions.length; i++){
            int u = conditions[i][0];
            int v = conditions[i][1];
            adj.computeIfAbsent(u, z -> new ArrayList<>()).add(v);
            indeg[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= k; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);
            for(int v : adj.getOrDefault(curr, new ArrayList<>())){
                indeg[v]--;
                if(indeg[v] == 0){
                    q.offer(v);
                }
            }
        }

        if(topo.size() < k){
            return new int[]{};
        }

        return topo.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] topoRow = topoSort(rowConditions, k);
        int[] topoCol = topoSort(colConditions, k);

        if(topoRow.length == 0 || topoCol.length == 0){
            return new int[][]{};
        }

        int res[][] = new int[k][k];

        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(topoRow[i] == topoCol[j]){
                    res[i][j] = topoRow[i];
                }
            }
        }

        return res;
    }
}