class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;

        int minIdx = -1;
        int maxIdx = -1;
        int culpritIdx = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < minK || nums[i] > maxK){
                culpritIdx = i;
            }

            if(nums[i] == minK){
                minIdx = i;
            }

            if(nums[i] == maxK){
                maxIdx = i;
            }

            long smaller = Math.min(minIdx, maxIdx);
            long temp = smaller - culpritIdx;
            ans += (temp < 0) ? 0 : temp;
        }

        return ans;
    }
}