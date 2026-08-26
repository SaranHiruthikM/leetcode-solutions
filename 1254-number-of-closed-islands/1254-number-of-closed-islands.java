class Solution {

    private boolean dfs(int[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;

        // Water / wall
        if (grid[i][j] == 1) {
            return true;
        }

        // 0 touching boundary => not closed
        if (i == 0 || i == m - 1 ||
            j == 0 || j == n - 1) {
            return false;
        }

        // Mark visited
        grid[i][j] = 1;

        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);
        boolean down = dfs(grid, i + 1, j);
        boolean up = dfs(grid, i - 1, j);

        return left && right && down && up;
    }

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}