class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] minIdx = new int[n];
        for(int i=n-1; i>=0; i--){
            if(st.isEmpty()){
                minIdx[i] = 0;
            }else{
                while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                    st.pop();
                }

                minIdx[i] = (st.isEmpty()) ? 0 : st.peek() - i;
            }
            st.push(i);
        }

        return minIdx;
    }
}