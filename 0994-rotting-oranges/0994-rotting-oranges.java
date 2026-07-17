class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        int level = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int[][] directions = {
                { -1, 0 },
                { 0, 1 },
                { 1, 0 },
                { 0, -1 }
        };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int dir[] : directions) {
                    int cr = curr[0] + dir[0];
                    int cc = curr[1] + dir[1];
                    if (cr >= 0 && cr < m && cc >= 0 && cc < n && grid[cr][cc] == 1) {
                        grid[cr][cc] = 2;
                        q.offer(new int[] { cr, cc });
                        freshCount--;
                    }
                }
            }

            if (!q.isEmpty()) {
                level++;
            }
        }

        return freshCount == 0 ? level : -1;
    }
}