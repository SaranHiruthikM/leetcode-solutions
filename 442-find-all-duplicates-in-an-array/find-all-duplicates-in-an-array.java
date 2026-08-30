class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] < 0){
                res.add(Math.abs(nums[i]));
                continue;
            }else{
                nums[idx] *= -1;
            }
        }

        return res;
    }
}