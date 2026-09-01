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

    public int largestRectangleArea(int[] heights) {
        int[] NSL = getNSL(heights);
        int[] NSR = getNSR(heights);
        int res = 0;
        for(int i=0; i<NSL.length; i++){
            int width = NSR[i] - NSL[i] - 1;
            res = Math.max(res, heights[i]*width);
        }

        return res;
    }
}