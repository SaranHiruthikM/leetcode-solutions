class Solution {
    public int minSwaps(int[] nums) {
        int left = 0, right = 0, maxOnes = 0, currOnes = 0, totOnes = 0;
        int n = nums.length;
        for(int num : nums){
            totOnes += (num == 1) ? 1 : 0;
        }
        while(right < 2*n){
            currOnes += (nums[right % n] == 1) ? 1 : 0;
            if(right - left + 1 > totOnes){
                currOnes -= nums[left % n];
                left++;
            }
            maxOnes = Math.max(maxOnes, currOnes);
            right++;
        }

        return totOnes - maxOnes;
    }
}