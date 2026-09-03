class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int b_count[] = new int[n];
        int a_count[] = new int[n];
        int count_b = 0;
        int count_a = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            char ch2 = s.charAt(n-1-i);
            b_count[i] = count_b;
            a_count[n-1-i] = count_a;
            if(ch == 'b'){
                count_b++;
            }
            if(ch2 == 'a'){
                count_a++;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, b_count[i]+a_count[i]);
        }

        return min;
    }
}