class Solution {
    int dirs[][] = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        boolean vis[][] = new boolean[m][n];
        vis[entrance[0]][entrance[1]] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                int curr[] = q.poll();
                int row = curr[0];
                int col = curr[1];

                

                if(row == 0 || row == m-1 || col == 0 || col == n-1){
                    if(row != entrance[0] || col != entrance[1]){
                        return level;
                    }
                }

                for(int dir[] : dirs){
                    int cr = row + dir[0];
                    int cc = col + dir[1];

                    if(cr >= 0 && cr < m && cc >= 0 && cc < n && maze[cr][cc] == '.' && !vis[cr][cc]){
                        q.offer(new int[]{cr, cc});
                        vis[cr][cc] = true;
                    }
                }

            }
            level++;
        }

        return -1;
    }
}