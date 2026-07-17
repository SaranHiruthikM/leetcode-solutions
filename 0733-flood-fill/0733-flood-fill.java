class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int oc = image[sr][sc];

        if(oc == color){
            return image;
        }

        image[sr][sc] = color;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };


        while(!queue.isEmpty()){
            int curr[] = queue.poll();
            for(int[] dir : directions){
                int cr = curr[0] + dir[0];
                int cc = curr[1] + dir[1];

                if(cr >= 0 && cr < m && cc >= 0 && cc < n && image[cr][cc] == oc){
                    image[cr][cc] = color;
                    queue.offer(new int[]{cr, cc});
                }
            }
        }

        return image;

    }
}