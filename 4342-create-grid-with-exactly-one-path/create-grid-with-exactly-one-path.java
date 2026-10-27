class Solution {
    public String[] createGrid(int m, int n) {
        int row = 0;
        int col = 0;
        String[] res = new String[m];
        char grid[][] = new char[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(grid[i], '#');
        }
        for(int i=0; i<n; i++){
            grid[row][i] = '.';
        }
        for(int i=0; i<m; i++){
            grid[i][n-1] = '.';
        }

        for(int i=0; i<m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(grid[i][j]);
            }
            res[i] = sb.toString();
        }

        return res;
    }
}