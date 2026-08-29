class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m = 0;

        for (int x : nums) {
            if (m == 0 || nums[m - 1] != x) {
                nums[m++] = x;
            }
        }
        int left = 0;
        int maxKeep = 0;
        for(int right=0; right<m; right++){
            while(nums[right] - nums[left] >= n){
                left++;
            }
            maxKeep = Math.max(maxKeep, right - left + 1);
        }

        return n - maxKeep;
    }
}