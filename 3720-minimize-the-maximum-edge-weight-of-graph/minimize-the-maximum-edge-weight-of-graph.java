class Solution {

    public int minMaxWeight(int n, int[][] edges, int threshold) {

        if (n == 1) return 0;
        if (threshold == 0) return -1;

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int low = Integer.MAX_VALUE;
        int high = 0;

        // Reverse the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(v).add(new int[]{u, w});

            low = Math.min(low, w);
            high = Math.max(high, w);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(adj, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(List<List<int[]>> adj, int n, int maxWeight) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int[] edge : adj.get(curr)) {
                int next = edge[0];
                int weight = edge[1];

                if (weight <= maxWeight && !vis[next]) {
                    vis[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }

        return count == n;
    }
}