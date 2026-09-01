class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalid = new HashSet<Integer>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }else if(ch == ')'){
                if(st.isEmpty()){
                    invalid.add(i);
                }else if(s.charAt(st.peek()) == '('){
                    st.pop();
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