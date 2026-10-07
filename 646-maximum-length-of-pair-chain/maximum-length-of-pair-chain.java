class Solution {
    int dp[][];
    private int solve(int[][] nums, int idx, int prevIdx){
        if(idx >= nums.length) return 0;

        int take = 0;
        int skip = 0;

        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1];
        }

        if(prevIdx == -1 || nums[idx][0] > nums[prevIdx][1]){
            take = 1 + solve(nums, idx+1, idx);
        }
        skip = solve(nums, idx+1, prevIdx);

        return dp[idx][prevIdx+1] = Math.max(take, skip);
    }
    public int findLongestChain(int[][] pairs) {
        dp = new int[pairs.length+1][pairs.length+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(pairs, 0, -1);
    }
}