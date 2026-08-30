class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean contains1 = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                contains1 = true;
            }
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }

        if(!contains1){
            return 1;
        }

        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0){
                continue;
            }
            nums[idx] = -Math.abs(nums[idx]);
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }

        return nums.length+1;
    }
}