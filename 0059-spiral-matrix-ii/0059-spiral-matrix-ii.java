class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        int num = 1;
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        while(top <= down && left <= right){
            for(int i=left; i<=right; i++){
                spiral[top][i] = num;
                num++;
            }
            top++;

            for(int i=top; i<=down; i++){
                spiral[i][right] = num;
                num++;
            }
            right--;

            for(int i=right; i>=left; i--){
                spiral[down][i] = num;
                num++;
            }
            down--;

            for(int i=down; i>=top; i--){
                spiral[i][left] = num;
                num++;
            }
            left++;
        }

        return spiral;
    }
}