class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = new int[m][n];

        int rowOnes[] = new int[m];
        int colOnes[] = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    rowOnes[i] += 1;
                    colOnes[j] += 1;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int onesRowi = rowOnes[i];
                int onesColj = colOnes[j];
                int zerosRowi = m - onesRowi;
                int zerosColj = n - onesColj;
                diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj;
            }
        }

        return diff;
    }
}