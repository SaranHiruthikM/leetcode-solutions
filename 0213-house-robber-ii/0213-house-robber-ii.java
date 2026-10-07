class Solution {
    private int solve(int[] nums, int[] dp, int i, int n){
        if(i > n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int steal = nums[i] + solve(nums, dp, i+2, n);
        int skip = solve(nums, dp, i+1, n);

        return dp[i] = Math.max(steal, skip);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int take0thHouse = solve(nums, dp, 0, nums.length-2);
        Arrays.fill(dp, -1);
        int take1stHouse = solve(nums, dp, 1, nums.length-1);
        return Math.max(take0thHouse, take1stHouse);
    }
}