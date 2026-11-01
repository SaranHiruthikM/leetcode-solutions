class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
        }

        int ops = 0;

        for(int num : nums){
            ops += (num - min);
        }

        return ops;
    }
}