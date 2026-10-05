class Solution {
    public int minTaps(int n, int[] ranges) {
        int startEnd[] = new int[n+1];
        for(int i=0; i<ranges.length; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            startEnd[left] = Math.max(startEnd[left], right);
        }

        int taps = 0;
        int maxEnd = 0;
        int currEnd = 0;

        for(int i=0; i<n+1; i++){
            if(i > maxEnd) return -1;
            
            if(i > currEnd){
                taps++;
                currEnd = maxEnd;
            }

            maxEnd = Math.max(maxEnd,startEnd[i]);
        }

        return taps; 
    }
}