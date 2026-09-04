class Solution {
    private int Prims(List<List<int[]>> adj, int V){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean vis[] = new boolean[V];
        pq.add(new int[]{0, 0});
        int sum = 0;
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int dist = curr[0];
            int node = curr[1];
            if(vis[node]){
                continue;
            }
            sum += dist;
            vis[node] = true;
            for(int v[] : adj.get(node)){
                if(!vis[v[1]]){
                    pq.offer(v);
                }
            }
        }

        return sum;
    }
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<points.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{dist, j});
                adj.get(j).add(new int[]{dist, i});
            }
        }

        return Prims(adj, points.length);
    }
}