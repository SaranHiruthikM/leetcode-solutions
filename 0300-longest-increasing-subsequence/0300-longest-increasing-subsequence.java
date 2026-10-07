class Solution {
    int dp[];
    // private int solve(int[] nums, int idx, int prevIdx){
    //     if(idx >= nums.length) return 0;

    //     int take = 0;
    //     int skip = 0;

    //     if(dp[idx][prevIdx+1] != -1){
    //         return dp[idx][prevIdx+1];
    //     }

    //     if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
    //         take = 1 + solve(nums, idx+1, idx);
    //     }
    //     skip = solve(nums, idx+1, prevIdx);

    //     return dp[idx][prevIdx+1] = Math.max(take, skip);
    // }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLis = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLis = Math.max(dp[i], maxLis);
                }
            }
        }

        return maxLis;
    }
}