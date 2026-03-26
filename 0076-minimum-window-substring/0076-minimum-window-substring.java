class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int left = 0;
        int right = 0;
        int have = 0;
        HashMap<Character, Integer> t_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();
        for(char ch  : t.toCharArray()){
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
        }
        int need = t_map.size();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < s.length()){
            char ch = s.charAt(right);
            s_map.put(ch, s_map.getOrDefault(ch, 0) + 1);
            if(t_map.containsKey(ch) && s_map.get(ch).intValue() == t_map.get(ch).intValue()){
                have++;
            }

            while(have == need){
                int length = right - left + 1;
                if (length < minLen) {
                    minLen = length;
                    start = left;
                }
                char leftch = s.charAt(left);
                s_map.put(leftch, s_map.get(leftch) - 1);
                if(t_map.containsKey(leftch) && s_map.get(leftch) < t_map.get(leftch)){
                    have--;
                }
                left++;
            }
            right++;
        }
            return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
        
    }
}