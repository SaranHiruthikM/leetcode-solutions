class Solution {
    private int[] getNSL(int[] height){
        Stack<Integer> st = new Stack<>();
        int res[] = new int[height.length];
        for(int i=0; i<height.length; i++){
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                while(!st.isEmpty() && height[st.peek()] >= height[i]){
                    st.pop();
                }
                res[i] = (st.isEmpty()) ? -1 : st.peek();
            }

            st.push(i);
        }

        return res;
    }

    private int[] getNSR(int[] height){
        Stack<Integer> st = new Stack<>();
        int res[] = new int[height.length];
        for(int i=height.length-1; i>=0; i--){
            if(st.isEmpty()){
                res[i] = height.length;
            }else{
                while(!st.isEmpty() && height[st.peek()] >= height[i]){
                    st.pop();
                }
                res[i] = (st.isEmpty()) ? height.length : st.peek();
            }

            st.push(i);
        }

        return res;
    }


    private int area(int[] height){
        int[] NSL = getNSL(height);
        int[] NSR = getNSR(height);
        int res = 0;
        for(int i=0; i<NSL.length; i++){
            int width = NSR[i] - NSL[i] - 1;
            res = Math.max(res, height[i]*width);
        }

        return res;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int height[] = new int[n];

        for(int i=0; i<n; i++){
            height[i] = (matrix[0][i] == '1') ? 1 : 0;
        }

        int maxArea = area(height);

        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else{
                    height[j] += 1;
                }
            }

            maxArea = Math.max(maxArea, area(height));
        }

        return maxArea;
    }
}