class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;

        for(int i=0; i<left.length; i++){
            maxLeft = Math.max(maxLeft, left[i]);
        }

        for(int i=0; i<right.length; i++){
            maxRight = Math.max(maxRight, n- right[i]);
        }

        return Math.max(maxLeft, maxRight);
    }
}