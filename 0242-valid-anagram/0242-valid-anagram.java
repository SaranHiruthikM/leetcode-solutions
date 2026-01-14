class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charArray1 = s.toCharArray();
        Arrays.sort(charArray1);
        s = new String(charArray1);
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray2);
        t = new String(charArray2);
        return s.equals(t);
    }
}