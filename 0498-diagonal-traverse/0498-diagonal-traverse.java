class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(new int[]{0,0});
        int d = 1;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-- > 0){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                temp.add(matrix[row][col]);
                if(col == 0 && row + 1 < m){
                    q.offer(new int[]{row+1, col});
                }

                if(col+1 < n){
                    q.offer(new int[]{row, col+1});
                }
            }
            if(d%2 != 0){
                res.addAll(temp);
            }else{
                Collections.reverse(temp);
                res.addAll(temp);
            }
            d++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}