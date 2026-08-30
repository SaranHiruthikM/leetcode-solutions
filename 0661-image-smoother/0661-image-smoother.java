class Solution {
    int[][] dirs = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 0}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum = 0;
                int cnt = 0;
                for(int dir[]: dirs){
                    int cr = i + dir[0];
                    int cc  = j + dir[1];

                    if(cr >= 0 && cr < m && cc >= 0 && cc < n){
                        sum += img[cr][cc] % 256;
                        cnt++;
                    }                    
                }
                int newVal = sum/cnt;
                img[i][j] += newVal*256;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                img[i][j] /= 256;
            }
        }

        return img;
    }
}