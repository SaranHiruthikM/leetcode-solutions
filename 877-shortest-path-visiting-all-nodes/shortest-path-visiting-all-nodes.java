class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n == 1) return 0;
        boolean vis[][] = new boolean[n][1<< n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.offer(new int[]{i, 1 << i});
            vis[i][1 << i] = true;
        }
        int finalValue = (1 << n) - 1;
        int path = 0;

        while(!q.isEmpty()){
            int size = q.size();
            path++;
            while(size-- > 0){
                int curr[] = q.poll();
                int currNode = curr[0];
                int currMask = curr[1];
                for(int i=0; i<graph[currNode].length; i++){
                    int newMask = currMask | (1 << graph[currNode][i]);
                    if(newMask == finalValue) return path;
                    if(!vis[graph[currNode][i]][newMask]){
                        vis[graph[currNode][i]][newMask] = true;
                        q.offer(new int[]{graph[currNode][i], newMask});
                    }
                }
            }
        }
        return path;
    }
}