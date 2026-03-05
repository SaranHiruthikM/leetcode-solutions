class Solution {
    List<List<String>> result = new ArrayList<>();

   boolean isSafe(char[][] board, int row, int col, int n){

    // check left row
    for(int j = 0; j < col; j++){
        if(board[row][j] == 'Q') return false;
    }

    // upper-left diagonal
    for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
        if(board[i][j]=='Q') return false;
    }

    // lower-left diagonal
    for(int i=row+1, j=col-1; i<n && j>=0; i++, j--){
        if(board[i][j]=='Q') return false;
    }

    return true;
}

    public void backtrack(char board[][], int col, int n){
        if(col == n){
            List<String> solution = new ArrayList<>();

            for(char[] r : board){
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                backtrack(board, col+1, n);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, n);
        return result;
    }

    
}