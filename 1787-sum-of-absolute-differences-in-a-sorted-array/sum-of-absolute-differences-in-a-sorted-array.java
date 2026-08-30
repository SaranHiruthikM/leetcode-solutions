class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];

        int sum = Arrays.stream(nums).sum();
        int prefixSum = 0;

        for(int i=0; i<n; i++){
            int leftSum = prefixSum;
            int rightSum = sum - prefixSum - nums[i];
            result[i] = i*nums[i] - leftSum + rightSum - ((n-1 -i)*nums[i]);

            prefixSum += nums[i]; 
        }

        return result;
    }
}