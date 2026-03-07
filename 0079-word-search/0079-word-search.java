class Solution {

    public boolean helper(char board[][], boolean vis[][], int row, int col, String word, int index){
        vis[row][col] = true;

        if(index == word.length()-1){
            return true;
        }
        //Check for left
        if(isSafe(board, vis, row, col-1, word, index+1)){
            if(helper(board, vis, row, col-1, word, index+1)){
                return true;
            }
        }
        if(isSafe(board, vis, row, col+1, word, index+1)){
            if(helper(board, vis, row, col+1, word, index+1)){
                return true;
            }
        }
        if(isSafe(board, vis, row-1, col, word, index+1)){
            if(helper(board, vis, row-1, col, word, index+1)){
                return true;
            }
        }
        if(isSafe(board, vis, row+1, col, word, index+1)){
            if(helper(board, vis, row+1, col, word, index+1)){
                return true;
            }
        }
        vis[row][col] = false;
        return false;
    }

    public boolean isSafe(char board[][], boolean vis[][], int row, int col, String word, int index){
        if(row >= board.length || row <0 || col >= board[0].length || col < 0){
            return false;
        }

        if(!vis[row][col] && board[row][col] == word.charAt(index)){
            return true;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, vis, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}