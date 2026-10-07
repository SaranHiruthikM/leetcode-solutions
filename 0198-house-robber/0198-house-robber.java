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
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=nums.length; i++){
            int skip = dp[i-1];
            int steal = nums[i-1] + dp[i-2];
            dp[i] = Math.max(skip, steal);
        }

        return dp[nums.length];
    }
}