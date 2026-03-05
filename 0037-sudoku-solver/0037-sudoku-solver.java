class Solution {
    public boolean isSafe(char i, int row, int col, char board[][]){
        for(int k=0; k<9; k++){
            if(board[row][k] == i) return false;
            if(board[k][col] == i) return false;
            int r = 3*(row/3) + k/3;
            int c = 3*(col/3) + k%3;

            if(board[r][c]==i) return false;
        }

        return true;
    }
    public boolean solve(char board[][]){
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                if (board[row][col] == '.'){
                    for(char i='1'; i<='9'; i++){
                        if(isSafe(i, row, col, board)){
                            board[row][col] = i;
                            if (solve(board)){
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}