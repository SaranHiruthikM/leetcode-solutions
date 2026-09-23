class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0, right = 0, maxLen = -1, currSum =0, totSum = 0;
        for(int num : nums){
            totSum += num;
        }
        int reqSum = totSum - x;
        if(reqSum < 0) return -1;
        System.out.println(reqSum);
        while(right < nums.length){
            currSum += nums[right];
            while(currSum > reqSum){
                currSum -= nums[left];
                left++;
            }
            if(currSum == reqSum) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return (maxLen == -1) ? -1 : nums.length - maxLen;
    }
}