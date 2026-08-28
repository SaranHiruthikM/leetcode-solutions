class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sold = new int[m][2];
        for(int i=0; i<m; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    cnt++;
                }
            }
            sold[i][0] = i;
            sold[i][1] = cnt;
        }

        Arrays.sort(sold, (a,b) -> {
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] res = new int[k];

for (int i = 0; i < k; i++) {
    res[i] = sold[i][0];
}

        return res;
    }
}