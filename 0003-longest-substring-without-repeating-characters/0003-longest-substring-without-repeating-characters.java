class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            int length = right - left + 1;
            maxLen = Math.max(maxLen, length);
            right++;
        }
        return maxLen;
    }
}