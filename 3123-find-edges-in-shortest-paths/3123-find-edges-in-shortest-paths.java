class Solution {
    HashMap<Integer, List<int[]>> adj = new HashMap<>();

    private int[] dijkstra(int n, int src) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.offer(new int[] { src, 0 });
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            for (int[] v : adj.getOrDefault(curr[0], new ArrayList<>())) {
                int u = v[0];
                int cost = v[1];
                if (dist[u] > curr[1] + cost) {
                    dist[u] = curr[1] + cost;
                    q.offer(new int[] { u, curr[1] + cost });
                }
            }
        }

        return dist;
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[] { v, w });
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[] { u, w });
        }

        int[] distFromStart = dijkstra(n, 0);
        int[] distFromEnd = dijkstra(n, n-1);
        boolean[] res = new boolean[edges.length];
        int shortest = distFromStart[n - 1];

        if (shortest == Integer.MAX_VALUE) return res;

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if (distFromStart[u] != Integer.MAX_VALUE
                    && distFromEnd[v] != Integer.MAX_VALUE
                    && distFromStart[u] + w + distFromEnd[v] == shortest) {
                res[i] = true;
            }

            if (distFromStart[v] != Integer.MAX_VALUE
                    && distFromEnd[u] != Integer.MAX_VALUE
                    && distFromStart[v] + w + distFromEnd[u] == shortest) {
                res[i] = true;
            }
        }

        return res;
    }
}