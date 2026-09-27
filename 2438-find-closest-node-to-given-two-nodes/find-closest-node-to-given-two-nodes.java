class Solution {
    private void dfs(int[] edges, int[] dist, boolean[] vis, int node, int depth){
        vis[node] = true;
        if(edges[node] != -1 && !vis[edges[node]]){
            dist[edges[node]] = depth;
            dfs(edges, dist, vis, edges[node], depth+1);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int dist1[] = new int[edges.length];
        int dist2[] = new int[edges.length];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        boolean vis[] = new boolean[edges.length];
        dist1[node1] = 0;
        dfs(edges, dist1, vis, node1, 1);
        boolean vis1[] = new boolean[edges.length];
        dist2[node2] = 0;
        dfs(edges, dist2, vis1, node2, 1);
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i=0; i<dist1.length; i++){
            if(dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) continue;
            if (min > Math.max(dist1[i], dist2[i])){
                min = Math.max(dist1[i], dist2[i]);
                minIdx = i;
            }
        }

        return minIdx;
    }
}