class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Set<String> set = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            if(set.contains(tokens[i])){
                if(tokens[i].equals("+")){
                    stack.push(stack.pop() + stack.pop());
                }else if(tokens[i].equals("-")){
                    int first = stack.pop();
                    stack.push(stack.pop() - first);
                }else if(tokens[i].equals("*")){
                    stack.push(stack.pop() * stack.pop());
                }else{
                    int div = stack.pop();
                    stack.push(stack.pop()/div);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}