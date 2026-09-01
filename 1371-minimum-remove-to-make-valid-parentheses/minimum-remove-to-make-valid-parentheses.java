class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalid = new HashSet<Integer>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!st.isEmpty()){
                if(ch == ')' && s.charAt(st.peek()) == '('){
                    st.pop();
                }else if(ch == ')' && s.charAt(st.peek()) != '('){
                    invalid.add(i);
                }else if(ch == '('){
                    st.push(i);
                }
            }else{
                if(ch == ')'){
                    invalid.add(i);
                }else if(ch == '('){
                    st.push(i);
                }
            }
        }

        while(!st.isEmpty()){
            invalid.add(st.pop());
        }

        int j=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!invalid.contains(i)){
                sb.insert(j, s.charAt(i));
                j++;
            }
        }

        return sb.toString();
    }
}