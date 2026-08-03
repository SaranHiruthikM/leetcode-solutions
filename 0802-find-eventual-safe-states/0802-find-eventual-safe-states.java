class Solution {
    public boolean isSafe(int[][] graph, int[] vis, int[] pathVis, int i) {
        vis[i] = 1;
        pathVis[i] = 1;

        for(int adj : graph[i]){
            if(vis[adj] == 0) {
                if (isSafe(graph, vis, pathVis, adj) == false){
                    return false;
                }
            }

            if(pathVis[adj] == 1){
                return false;
            }
        }

        pathVis[i] = 0;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] pathVis = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            isSafe(graph, vis, pathVis, i);
        }

        for(int i=0; i<pathVis.length; i++){
            if(pathVis[i] == 0){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}