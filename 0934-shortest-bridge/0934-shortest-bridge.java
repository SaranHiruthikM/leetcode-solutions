class Solution {
    private int bfs(int[][] grid, boolean[][] vis, Queue<int[]> q){
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int dir[] : directions){
                    int cr = row + dir[0];
                    int cc = col + dir[1];

                    if(cr >= 0 && cr < m && cc >= 0 && cc < n && !vis[cr][cc]){
                        if(grid[cr][cc] == 1){
                            return steps;
                        }
                        q.offer(new int[]{cr, cc});
                        vis[cr][cc] = true;
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    private void dfs(int[][] grid, boolean[][] vis, Queue<int[]> q, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || vis[i][j]){
            return;
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        q.offer(new int[]{i, j});
        vis[i][j] = true;

        for(int dir[] : directions){
            int cr = i + dir[0];
            int cc = j + dir[1];
            dfs(grid, vis, q, cr, cc);
        }
        
    }
    

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, vis, q,  i, j);
                    return bfs(grid, vis, q);
                }
            }
        }

        return -1;
    }
}