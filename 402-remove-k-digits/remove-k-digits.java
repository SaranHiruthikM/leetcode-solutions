class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()){
            return "0";
        }
        Stack<Integer> st = new Stack<>();
        for(char ch : num.toCharArray()){
            if(st.isEmpty()){
                st.add(ch - '0');
            }else{
                while(!st.isEmpty() && k > 0 && st.peek() > (ch - '0')){
                    st.pop();
                    k--;
                }
                st.push(ch - '0');
            }
        }

        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(String.valueOf(st.pop()));
        }

        sb.reverse();

        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) != '0'){
                return sb.substring(i).toString();
            }
        }

        return "0";
    }
}