class Solution {
    public String countAndSay(int n) {
        String str = "1";

        for(int k=1; k<n; k++){
            StringBuilder next = new StringBuilder();
            int i=0;

            while(i < str.length()){
                char curr = str.charAt(i);
                int count = 0;
                while(i < str.length() && curr == str.charAt(i)){
                    count++;
                    i++;
                }
                next.append(count);
                next.append(curr);
            }

            str = next.toString();
        }

        return str;
    }
}