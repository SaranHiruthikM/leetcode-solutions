class Solution {
    public int reductionOperations(int[] nums) {
        int ops = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=1; i--){
            if(nums[i] == nums[i-1]){
                continue;
            }

            ops += nums.length - i;
        }

        return ops;
    }
}