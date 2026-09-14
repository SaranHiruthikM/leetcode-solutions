class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int grid[][] = new int[rows*cols][2];
        int steps = 0;
        int dir = 0;
        int index = 0;
        grid[index++] = new int[]{rStart, cStart};
        while(index < rows * cols){
            if(dir == 0 || dir == 2) steps++;

            for(int count = 0; count < steps; count++){
                rStart += directions[dir][0];
                cStart += directions[dir][1];

                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                    grid[index++] = new int[]{rStart, cStart};
                }
            }

            dir = (dir+1)%4;
        }

        return grid;
    }
}