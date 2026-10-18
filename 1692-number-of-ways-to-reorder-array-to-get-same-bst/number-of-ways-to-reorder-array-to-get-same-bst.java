class Solution {
    static final int MOD = 1_000_000_007;
    long[][] pascal;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        pascal = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            pascal[i][0] = pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = (pascal[i - 1][j - 1]
                        + pascal[i - 1][j]) % MOD;
            }
        }

        return (int) ((solve(nums) - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 1;

        int root = nums[0];
        int[] left = new int[n];
        int[] right = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) left[l++] = nums[i];
            else right[r++] = nums[i];
        }

        long ways = pascal[l + r][l];
        ways = ways * solve(java.util.Arrays.copyOf(left, l)) % MOD;
        ways = ways * solve(java.util.Arrays.copyOf(right, r)) % MOD;

        return ways;
    }
}