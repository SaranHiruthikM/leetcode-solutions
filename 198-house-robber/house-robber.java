class Solution {
    private int solve(int[] nums, int[] dp, int i){
        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int steal = nums[i] + solve(nums, dp, i+2);
        int skip = solve(nums, dp, i+1);

        return dp[i] = Math.max(steal, skip);
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, dp, 0);
    }
}