class Solution {
    private boolean operate(int falseC, int trueC, char operator) {
        if (operator == '!') {
            return falseC == 1;
        } else if (operator == '&') {
            return falseC == 0;
        } else {
            return trueC > 0;
        }
    }
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        int i =0;
        Stack<Character> st = new Stack<>();
        while(i < n){
            if(expression.charAt(i) == ')'){
                int falseC = 0;
                int trueC = 0;
                while(!st.isEmpty() && st.peek() != '('){
                    if(st.peek() == 'f'){
                        falseC ++;
                    }else if(st.peek() == 't'){
                        trueC++;
                    }

                    st.pop();
                }

                st.pop();
                char op = st.pop();
                boolean result = operate(falseC, trueC, op);
                st.push(result ? 't' : 'f');
            }else{
                if(expression.charAt(i) != ',') st.push(expression.charAt(i));
            }
            i++;
        }

        return st.pop() == 't';
    }
}