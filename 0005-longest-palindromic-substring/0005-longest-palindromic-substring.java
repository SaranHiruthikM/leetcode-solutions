    class Solution {
        public int expandAroundCenters(String s, int left, int right){
            int n = s.length();
            while(left >= 0 && right < n && (s.charAt(left) == s.charAt(right))){
                left --;
                right++;
            }
            return right - left -1 ;
        }

        public String longestPalindrome(String s) {
            int n = s.length();
            int start = 0;
            int maxLen = 1;
            for(int i=0; i<n; i++){
                int len1 = expandAroundCenters(s, i, i);
                int len2 = expandAroundCenters(s, i, i+1);
                int len = Math.max(len1, len2);
                if(len > maxLen){
                    start = i - (len - 1) / 2;;
                    maxLen = len;
                }
            }
            return s.substring(start, start + maxLen);
        }
    }