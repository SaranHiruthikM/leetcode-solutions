class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // skip spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            int j = i;

            // find word start
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // append word
            if (ans.length() > 0) ans.append(" ");
            ans.append(s.substring(i + 1, j + 1));
        }

        return ans.toString();
    }
}
