class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack =  new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty()){
                if(stack.peek() == ch){
                    stack.pop();
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }
            }
            stack.push(ch);
            sb.append(ch);
        }

        return sb.toString();
    }
}