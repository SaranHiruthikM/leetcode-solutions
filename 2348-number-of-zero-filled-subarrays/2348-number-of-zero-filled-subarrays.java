class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int start = 0;
        while(start < nums.length){
            if(nums[start] == 0){
                int cnt = 0;
                while(start < nums.length && nums[start] == 0){
                    cnt++;
                    start++;
                }
                res += (long) cnt*(cnt+1)/2;
            }
            start++;
        }

        return res;
    }
}