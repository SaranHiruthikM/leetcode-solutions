class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                st.pop();
                sb.setLength(sb.length()-1);
            }else{
                st.push(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}