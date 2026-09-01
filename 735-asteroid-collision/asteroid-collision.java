class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            int curr = asteroids[i];
            while(!st.isEmpty() && st.peek() > 0 && curr < 0){
                int sum = st.peek() + curr;
                if(sum < 0){
                    st.pop();
                }else if(sum == 0){
                    st.pop();
                    curr = 0;
                }else{
                    curr = 0;
                }
            }

            if(curr != 0) st.push(curr);
        }

        int res[] = new int[st.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = st.pop();
        }

        return res;
    }
}