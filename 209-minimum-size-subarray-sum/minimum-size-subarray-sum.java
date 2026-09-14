class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currSum = 0;
        int n  = nums.length;
        int min = Integer.MAX_VALUE;
        while(right < n){
            currSum += nums[right];
            while(currSum >= target){
                min = Math.min(min, right - left + 1);
                currSum -= nums[left];
                left++;
            }

            right++;
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}