class Solution {
    public void dfs(int[][] mat, int[][] vis, int[][] dist, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = 1;
                    dist[i][j] = 0;
                }
            }
        }

        int[][] direction = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int dir[] : direction){
                int cr = curr[0] + dir[0];
                int cc = curr[1] + dir[1];

                if(cr >= 0 && cr <m && cc >=0 && cc < n && vis[cr][cc] != 1){
                    q.offer(new int[]{cr, cc, curr[2] + 1});
                    vis[cr][cc] = 1;
                    dist[cr][cc] = curr[2]+1;
                }
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];
        dfs(mat, vis, dist, m, n);
        return dist;
    }
}