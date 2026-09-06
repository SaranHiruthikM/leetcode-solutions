class Solution {
    private boolean bfs(int color[], HashMap<Integer, List<Integer>> adj, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v : adj.getOrDefault(curr, new ArrayList<>())){
                if(color[v] == -1){
                    color[v] = 1 - color[curr];
                    q.add(v);
                }

                if(color[v] == color[curr]){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int color[] = new int[n+1];
        Arrays.fill(color, -1);
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<dislikes.length; i++){
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        for(int i=1; i<=n; i++){
            if (color[i] == -1) {
                if (!bfs(color, adj, i)) {
                    return false;
                }
            }
        }

        return true;
    }
}