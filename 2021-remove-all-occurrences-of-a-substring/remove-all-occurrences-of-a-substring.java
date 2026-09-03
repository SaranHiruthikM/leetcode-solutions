class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int m = part.length();

        for (char ch : s.toCharArray()) {
            sb.append(ch);

            // Check whether the end of sb matches part
            if (sb.length() >= m) {
                boolean found = true;

                for (int j = 0; j < m; j++) {
                    if (sb.charAt(sb.length() - m + j) != part.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                // Remove part if found
                if (found) {
                    sb.setLength(sb.length() - m);
                }
            }
        }

        return sb.toString();
    }
}