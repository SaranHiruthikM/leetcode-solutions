class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;

        int cost = 0;
        for(int i=0; i<nums.length; i++){
            cost += Math.abs(nums[i] - nums[mid]);
        }
        
        return cost;
    }
}