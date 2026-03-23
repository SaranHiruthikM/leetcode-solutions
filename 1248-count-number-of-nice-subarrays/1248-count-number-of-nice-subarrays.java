class Solution {
    public int atmostK(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int odd = 0;
        while(right < arr.length){
            if(arr[right] % 2 == 1){
                odd++;
            }

            while(odd > k){
                if(arr[left] % 2 == 1){
                    odd--;
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] arr, int k) {
        return atmostK(arr, k) - atmostK(arr, k-1);
    }
}