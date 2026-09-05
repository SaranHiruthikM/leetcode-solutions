class Solution {
    private List<Integer> path = new ArrayList<>();
    private void dfs(int start, Map<Integer, List<Integer>> adj){
        List<Integer> neighbours = adj.get(start);
        while(neighbours != null && !neighbours.isEmpty()){
            int next = neighbours.remove(neighbours.size() - 1);
            dfs(next, adj);
        }

        path.add(start);
    }
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> outDeg = new HashMap<>();
        Map<Integer, Integer> inDeg = new HashMap<>();
        int n = pairs.length;
        for(int i=0; i<n; i++){
            int u = pairs[i][0];
            int v = pairs[i][1];
            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            outDeg.put(u, outDeg.getOrDefault(u, 0) + 1);
            inDeg.put(v, inDeg.getOrDefault(v, 0) + 1);
        }

        int start = pairs[0][0];
        for(int node : outDeg.keySet()){
            if(outDeg.get(node) == inDeg.getOrDefault(node, 0) + 1){
                start = node;
                break;
            }
        }

        dfs(start, adj);
        Collections.reverse(path);

        int[][] result = new int[n][2];
        for(int i=0; i<n; i++){
            result[i] = new int[]{path.get(i), path.get(i+1) };
        }

        return result;
    }
}
