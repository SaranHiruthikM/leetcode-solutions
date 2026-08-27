class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] pairsum = new int[weights.length-1];
        for(int i=0; i<weights.length-1; i++){
            pairsum[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(pairsum);
        long maxSum = 0;
        long minSum = 0;
        for(int i=0; i<k-1; i++){
            minSum += pairsum[i];
            maxSum += pairsum[weights.length - 2 - i];
        }

        return maxSum - minSum;
    }
}