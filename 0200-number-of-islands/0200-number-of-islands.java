class Solution {

    private void dfs(char[][] grid, int[][] vis, int m, int n, int i, int j) {
        if( i < 0 || i >=m || j < 0 || j >= n || grid[i][j] == '0' || vis[i][j] == 1){
            return;
        }
        int[][] directions = {
            {0, -1},
            {0, +1},
            {1, 0},
            {-1, 0}
        };

        vis[i][j] = 1;

        for(int[] dir : directions){
            int cr = dir[0] + i;;
            int cc = dir[1] + j;

            dfs(grid, vis, m, n, cr, cc);
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    dfs(grid, vis, m, n, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}