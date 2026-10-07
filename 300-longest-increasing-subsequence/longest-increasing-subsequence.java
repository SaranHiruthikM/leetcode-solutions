class Solution {
    int dp[][];
    private int solve(int[] nums, int idx, int prevIdx){
        if(idx >= nums.length) return 0;

        int take = 0;
        int skip = 0;

        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1];
        }

        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1 + solve(nums, idx+1, idx);
        }
        skip = solve(nums, idx+1, prevIdx);

        return dp[idx][prevIdx+1] = Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, -1);
    }
}