class Solution {
    long dp[][];
    public long solve(int[] nums, int idx, int multiplier){
        if(idx >= nums.length) return 0;

        if(dp[idx][multiplier+1] != -1){
            return dp[idx][multiplier+1];
        }

        long take = nums[idx] * multiplier + solve(nums, idx+1, multiplier*(-1));
        long skip = solve(nums, idx+1, multiplier);

        return dp[idx][multiplier+1] = Math.max(take, skip);

    }
    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length][3];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, 1);
    }
}