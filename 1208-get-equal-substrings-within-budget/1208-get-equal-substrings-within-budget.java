class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        long currCost = 0;
        int max = Integer.MIN_VALUE;
        while(right < s.length()){
            char ch1 = s.charAt(right);
            char ch2 = t.charAt(right);
            currCost += Math.abs(ch1 - ch2);
            while(currCost > maxCost){
                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}