class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(sb.length());
            }else if(ch == ')'){
                int start = st.pop();
                int end = sb.length();
                String reversedSub = new StringBuilder(sb.substring(start, end)).reverse().toString();
                sb.replace(start, end, reversedSub);
            }else{  
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}