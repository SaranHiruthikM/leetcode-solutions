class Solution {
    public boolean bfs(int[][] graph, int[] color, int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        color[i] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int adj : graph[curr]){
                if(color[adj] == -1){
                    color[adj] = 1 - color[curr];
                    q.offer(adj);
                } else if(color[adj] != 1 - color[curr]) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i] ==  -1){
                if(bfs(graph, color, i) == false){
                    return false;
                }
            }
        }
        return true;
    }
}