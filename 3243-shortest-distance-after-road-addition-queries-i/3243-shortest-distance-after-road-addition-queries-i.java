class Solution {
    private int bfs(int n, HashMap<Integer, List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int level = 0;
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                if(curr == n-1){
                    return level;
                }
                for(int v : adj.getOrDefault(curr, new ArrayList<>())){
                    if(!vis[v]) {
                        q.offer(v);
                        vis[v] = true;
                    };
                }
            }
            level++;
        }

        return level;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<n-1; i++){
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i+1);
        }

        int res[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            res[i] = bfs(n, adj);
        }

        return res;
    }
}