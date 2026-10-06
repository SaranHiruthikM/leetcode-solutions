class Solution {
    private int solve(int n, int dp[]){
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }
    public int climbStairs(int n) {
        int dp[] = new int[46];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            int oneStep = (i-1 < 0) ? 0 : dp[i-1];
            int twoStep = (i-2 < 0) ? 0 : dp[i-2];
            dp[i] = oneStep + twoStep;
        }

        return dp[n];
    }
}