class Solution {
    public int longestSubarray(int[] arr) {
        int left  =0;
        int right = 0;
        int zeroes = 0;
        int max = Integer.MIN_VALUE;
        while(right < arr.length){
            if(arr[right] == 0){
                zeroes++;
            }

            while(zeroes > 1){
                if(arr[left] == 0){
                    zeroes--;
                }
                left++;
            }

            max = Math.max(max, right-left);
            right++;
        }

        return max;
    }
}