class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        // dp[r] stores the number of subarrays ending at the current position 
        // whose product modulo k equals r
        int[] dp = new int[k];
        
        for (int num : nums) {
            int[] newDp = new int[k];
            int numMod = num % k;
            
            // 1. Start a new subarray containing only the current element
            newDp[numMod] += 1;
            
            // 2. Extend all valid subarrays that ended at the previous element
            for (int i = 0; i < k; i++) {
                if (dp[i] > 0) {
                    int newMod = (i * numMod) % k;
                    newDp[newMod] += dp[i];
                }
            }
            
            // 3. Accumulate counts from the current position into the final answer
            for (int i = 0; i < k; i++) {
                ans[i] += newDp[i];
            }
            
            // Move to the next iteration
            dp = newDp;
        }
        
        return ans;
    }
}
