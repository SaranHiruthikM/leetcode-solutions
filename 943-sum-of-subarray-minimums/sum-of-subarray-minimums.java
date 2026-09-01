class Solution {

    private int[] getNSL(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                    st.pop();
                }

                res[i] = (st.isEmpty()) ? -1 : st.peek();
            }
            st.push(i);
        }

        return res;
    }

    private int[] getNSR(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=n-1; i>=0; i--){
            if(st.isEmpty()){
                res[i] = n;
            }else{
                while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
                }

                res[i] = (st.isEmpty()) ? n : st.peek();
            }
            st.push(i);
        }

        return res;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        int M = 1_000_000_007;
        long sum = 0;
        for(int i=0; i<n; i++){
            int ls = i-NSL[i];
            int rs = NSR[i]-i;

            long contribution = ((long) ls * rs) % M;
            contribution = (contribution * arr[i]) % M;

            sum = (sum + contribution) % M;
        }

        return (int) sum;
    }
}