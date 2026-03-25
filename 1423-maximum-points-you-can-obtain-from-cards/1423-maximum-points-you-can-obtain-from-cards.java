class Solution {
    public int maxScore(int[] arr, int k) {
        int left = k-1;
        int n = arr.length - 1;
        int right = arr.length - 1;
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        int maxSum = sum;
        while(left >= 0){
            sum -= arr[left--];
            sum += arr[right];
            maxSum = Math.max(sum, maxSum);
            right--;
        }
        return maxSum;
    }
}