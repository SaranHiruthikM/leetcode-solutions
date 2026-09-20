class Solution {
    public long countSubarrays(int[] nums, int k) {
        int left = 0, right = 0, maxCnt = 0, max = 0;
        long res = 0;

        for(int num : nums){
            max = Math.max(max, num);
        }

        while(right < nums.length){
            maxCnt += (nums[right] == max) ? 1 : 0;
            while(maxCnt >= k){
                res += (nums.length - right);
                maxCnt -= (nums[left] == max) ? 1 : 0;
                left++;
            }
            right++;
        }

        return res;
    }
}