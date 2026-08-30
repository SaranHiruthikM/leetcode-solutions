class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int result[] = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i=0; i<n; i++){
            int left = (i == 0) ? 0 : (i*nums[i])-prefix[i-1];
            int right = (i == n-1) ? 0 : ((prefix[n-1] - prefix[i]) - ((n - 1 - i)*nums[i]));
            result[i] = left + right;
        }

        return result;
    }
}