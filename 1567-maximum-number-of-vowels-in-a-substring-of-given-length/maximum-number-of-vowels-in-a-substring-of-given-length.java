class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int left = 0;
        int right  =0;
        int currLen = 0;
        int max = Integer.MIN_VALUE;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(set.contains(ch)){
                currLen++;
            }

            if(right - left + 1 == k){
                max = Math.max(max, currLen);
                if(set.contains(s.charAt(left))){
                    currLen--;
                }
                left++;
            }

            right++;
        }

        return max;
    }
}