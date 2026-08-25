class Solution {
    private int[] getCoord(int num, int n) {

        int row = (num - 1) / n;
        int col = (num - 1) % n;

        int boardRow = n - 1 - row;

        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{boardRow, col};
    }

    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        int[] start = getCoord(1, n);
        vis[start[0]][start[1]] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                if (curr == m * n) {
                    return steps;
                }

                for (int i = 1; i <= 6; i++) {

                    int next = curr + i;

                    if (next > m * n) {
                        break;
                    }

                    int[] coord = getCoord(next, n);

                    int row = coord[0];
                    int col = coord[1];

                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    int[] nextCoord = getCoord(next, n);

                    if (!vis[nextCoord[0]][nextCoord[1]]) {
                        vis[nextCoord[0]][nextCoord[1]] = true;
                        q.add(next);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}