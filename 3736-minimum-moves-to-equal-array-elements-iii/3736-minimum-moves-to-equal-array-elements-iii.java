class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int cost = 0;
        for(int i=0; i<nums.length; i++){
            cost += Math.abs(nums[i] - nums[nums.length-1]);
        }
        return cost;
    }
}