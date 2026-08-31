class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long cnt = 0;
        for(int i=0; i<nums.length; i++){
            int j = i;
            while(j+1 < nums.length && nums[j] != nums[j+1]){
                j++;
            }

            int len = j - i + 1;
            cnt += (long) len*(len+1)/2;
            i=j;
        }

        return cnt;
        
    }
}