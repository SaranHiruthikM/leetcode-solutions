class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);

        if(k == 0){
            return nums;
        }

        if(2*k + 1 > n){
            return res;
        }

        long[] prefix = new long[n+1];
        
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        for(int i=k; i+k<n; i++){
            long sum = prefix[i+k+1] - prefix[i-k];
            int avg = (int)(sum / (2*k + 1));
            res[i] = avg;
        }

        return res;
    }
}