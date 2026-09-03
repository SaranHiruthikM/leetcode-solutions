class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int count_b = 0;
        int count_a = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'a'){
                count_a++;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            count_a -= (s.charAt(i) == 'a') ? 1 : 0;
            min = Math.min(min, count_b+count_a);
            count_b += (s.charAt(i) == 'b') ? 1 : 0;
        }

        return min;
    }
}