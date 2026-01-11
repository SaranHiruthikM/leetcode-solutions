class Solution {
    public String reverse(StringBuilder s){
        return s.reverse().toString();
    }

    public String reverseWords(String s) {
        int n = s.length();
        int i = 0;

        StringBuilder word = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse(); // now we ACTUALLY reverse

        while (i < n) {
            // skip spaces
            while (i < n && sb.charAt(i) == ' ') {
                i++;
            }

            // collect word
            while (i < n && sb.charAt(i) != ' ') {
                word.append(sb.charAt(i));
                i++;
            }

            if (word.length() > 0) {
                word.reverse();   // reverse the word

                if (ans.length() > 0) ans.append(" ");
                ans.append(word);

                word.setLength(0); 
            }
        }
        return ans.toString();
    }
}
