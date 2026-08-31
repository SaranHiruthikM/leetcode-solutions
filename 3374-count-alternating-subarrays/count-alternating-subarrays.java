class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 1;
        int len = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                len++;
            }else{
                len = 1;
            }

            ans += len;
        }

        return ans;
    }
}