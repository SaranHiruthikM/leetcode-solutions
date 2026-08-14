class Solution {
    public int dijkstra(int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        q.add(new int[]{1,0,0});
        int directions[][] = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int dis = curr[0];
            int row = curr[1];
            int col = curr[2];
            if(row == m-1 && col == n-1){
                return dis;
            }
            
            for(int[] dir : directions) {
                int cr = row + dir[0];
                int cc = col + dir[1];

                if(cr >= 0 && cr < m &&
                   cc >= 0 && cc < n &&
                   grid[cr][cc] == 0) {

                    grid[cr][cc] = 1;
                    q.offer(new int[]{dis+1, cr, cc});
                }
            }
        }

        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        return dijkstra(grid);
    }
}