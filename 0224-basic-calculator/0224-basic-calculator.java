class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number = (number*10 + Character.getNumericValue(ch));
            }else if(ch == '+'){
                result += number*sign;
                sign = 1;
                number = 0;
            }else if(ch == '-'){
                result += number*sign;
                sign = -1;
                number = 0;
            }else if(ch == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
                number = 0;
            }else if(ch == ')'){
                result += (number * sign);
                number = 0;

                int stack_sign = st.pop();
                int stack_res = st.pop();

                result *= stack_sign;
                result += stack_res;
            }
        }

        result += (number*sign);
        return result;
    }
}