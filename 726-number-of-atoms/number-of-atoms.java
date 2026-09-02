class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int i =0 ;
        while (i < n){
            if(formula.charAt(i) == '('){
                st.push(new HashMap<>());
                i++;
            }else if(formula.charAt(i) == ')'){
                Map<String, Integer> mp = st.pop();
                i++;
                StringBuilder sb = new StringBuilder();
                while(i < n && Character.isDigit(formula.charAt(i))){
                    sb.append(formula.charAt(i));
                    i++;
                }

                int multiplier = (String.valueOf(sb).equals("")) ? 1 : Integer.parseInt(String.valueOf(sb));
                mp.replaceAll((key, value) -> value * multiplier);

           
                    Map<String, Integer> mp2 = st.pop();
                    mp2.forEach((key, value) -> mp.merge(key, value, Integer::sum));
         

                st.push(mp);
            }else {
                StringBuilder sb = new StringBuilder();
                sb.append(formula.charAt(i));
                i++;
                while(i < n && Character.isLowerCase(formula.charAt(i))){
                    sb.append(formula.charAt(i));
                    i++;
                }
                
                StringBuilder num = new StringBuilder();
                while(i < n && Character.isDigit(formula.charAt(i))){
                    num.append(formula.charAt(i));
                    i++;
                }

                int subscript = (String.valueOf(num).equals("")) ? 1 : Integer.parseInt(String.valueOf(num));

                st.peek().put(String.valueOf(sb), st.peek().getOrDefault(sb.toString(), 0) + subscript);
            }
        }

        StringBuilder result = new StringBuilder();
        Map<String, Integer> finalMap = st.pop();
        Map<String, Integer> sortedMap = new TreeMap<>(finalMap);
        sortedMap.forEach((key, value) -> {
                result.append(key);
                if(value != 1){
                    result.append(value);
                }                
            }
        );

        return result.toString();
    }
}