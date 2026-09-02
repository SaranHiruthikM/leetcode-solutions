class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(sb);
                sb = new StringBuilder();
            }else if(ch == ')'){
                sb.reverse();
                StringBuilder prev = st.pop();
                prev.append(sb);
                sb = prev;
            }else{  
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}