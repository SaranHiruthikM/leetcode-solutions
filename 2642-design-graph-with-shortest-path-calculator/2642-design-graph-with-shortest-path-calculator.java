class Graph {
    HashMap<Integer, List<int[]>> adj;
    int N = 0;
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    public Graph(int n, int[][] edges) {
        N = n;
        adj = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, d});
        }
    }
    
    public void addEdge(int[] edge) {
        adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int dist[] = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1]  = 0;
        q.offer(new int[]{node1, 0});
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int d = curr[1];
            int node = curr[0];

            for(int v[] : adj.getOrDefault(node, new ArrayList<>())){
                if(d+v[1] < dist[v[0]]){
                    dist[v[0]] = d+v[1];
                    q.add(new int[]{v[0], dist[v[0]]});
                }
            }
        }

        return (dist[node2] == Integer.MAX_VALUE) ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */