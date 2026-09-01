class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        int n = pushed.length;
        Stack<Integer> st = new Stack<>();
        
        while(i < n ){
            st.push(pushed[i]);
            while(!st.isEmpty() && popped[j] == st.peek()){
                j++;
                st.pop();
            }
            i++;
        }

        return st.isEmpty();
    }
}