class Solution {
    int m = 0;
    int n = 0;
    private boolean isSafe(int row, int col){
        return (row >= 0 && row < m && col >= 0 && col < n);
    }
    public int minimumObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[]{0, 0});

        while(!q.isEmpty()){
            int curr[] = q.pollFirst();
            int i = curr[0];
            int j = curr[1];

            if(i == m-1 && j == n-1){
                return dist[i][j];
            }

            for(int dir[] : directions){
                int cr = i + dir[0];
                int cc = j + dir[1];

                if(isSafe(cr, cc)){
                    int weight = grid[cr][cc];
                    if (dist[i][j] + weight < dist[cr][cc]) {
                        dist[cr][cc] = dist[i][j] + weight;

                        if (weight == 0)
                            q.offerFirst(new int[]{cr, cc});
                        else
                            q.offerLast(new int[]{cr, cc});
                    }
                }
            }
        }

        return dist[m-1][n-1];
    }
}