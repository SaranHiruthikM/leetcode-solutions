class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            // Return false if lengths don't match
            return false;
        }
        String newStr = s + s;
        return newStr.contains(goal);
    }
}