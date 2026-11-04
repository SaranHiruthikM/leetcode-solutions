class Solution {
    int[][] directions = {{-1,0}, {0,1}, {0,-1}, {1,0}};
    int m, n;

    private boolean isSafe(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public int minimumTime(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (m == 1 && n == 1) return 0;

        if ((m == 1 || grid[1][0] > 1) &&
            (n == 1 || grid[0][1] > 1)) {
            return -1;
        }

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int row = curr[0];
            int col = curr[1];
            int time = curr[2];

            if (time > dist[row][col]) continue;

            if (row == m - 1 && col == n - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (!isSafe(nr, nc)) continue;

                int nextTime = time + 1;

                if (nextTime < grid[nr][nc]) {
                    int diff = grid[nr][nc] - nextTime;
                    nextTime = grid[nr][nc] + (diff % 2);
                }

                if (nextTime < dist[nr][nc]) {
                    dist[nr][nc] = nextTime;
                    pq.offer(new int[]{nr, nc, nextTime});
                }
            }
        }

        return -1;
    }
}