class Solution {
    public int dijkstra(int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0, 0});
        int dist[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, +1}
        };
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int minDif = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == m-1 && col == n-1){
                return minDif;
            }

            for(int dir[] : directions){
                int cr = row + dir[0];
                int cc = col + dir[1];

                
                if(cr >= 0 && cr < m && cc >= 0 && cc < n ) {
                    int newEffort = Math.max(minDif, Math.abs(heights[row][col] - heights[cr][cc]));
                    if(newEffort < dist[cr][cc]){
                        pq.offer(new int[]{newEffort, cr, cc});
                        dist[cr][cc] = newEffort;
                    }
                    
                }
            }
        }

        return -1;
    }
    public int minimumEffortPath(int[][] heights) {
        return dijkstra(heights);
    }
}