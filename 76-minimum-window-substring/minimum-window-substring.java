class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int n = s.length();
        int reqCount = t.length();
        int minWindowSize =Integer.MAX_VALUE;
        int start_i = 0;
        int left = 0;
        int right = 0;
        while(right < n){
            char ch = s.charAt(right);
            if(map.getOrDefault(ch, 0) > 0){
                reqCount--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);
            
            while(reqCount == 0){
                int currWindowSize = right - left + 1;
                if(minWindowSize > currWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = left;
                }
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
                if(map.getOrDefault(s.charAt(left), 0) > 0){
                    reqCount++;
                }
                left++;
            }

            right++;
        }

        return (minWindowSize == Integer.MAX_VALUE) ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}