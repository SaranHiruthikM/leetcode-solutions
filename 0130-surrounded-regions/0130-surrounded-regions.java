class Solution {
    public void dfs(char[][] board, int[][] vis, int m, int n){
        int r = board.length;
        int c = board[0].length;
        if(m < 0 || m >= r || n < 0 || n >= c || board[m][n] == 'X' || vis[m][n] == 1){
            return;
        }
        vis[m][n] = 1;
        dfs(board, vis, m-1, n);
        dfs(board, vis, m+1, n);
        dfs(board, vis, m, n-1);
        dfs(board, vis, m, n+1);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O' && vis[0][i] != 1){
                dfs(board, vis, 0, i);
            }

            if(board[m-1][i] == 'O' && vis[m-1][i] != 1){
                dfs(board, vis, m-1, i);
            }
        }

        for(int i=0; i<m; i++){
            if(board[i][0] == 'O' && vis[i][0] != 1){
                dfs(board, vis, i, 0);
            }

            if(board[i][n-1] == 'O' && vis[i][n-1] != 1){
                dfs(board, vis, i, n-1);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O' && vis[i][j] != 1){
                    board[i][j] = 'X';
                }
            }
        }
    }
}