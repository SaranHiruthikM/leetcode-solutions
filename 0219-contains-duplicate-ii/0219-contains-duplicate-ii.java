class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while(right < nums.length){

            if(Math.abs(left - right) > k){
                set.remove(nums[left]);
                left++;
            }
            
            if(set.contains(nums[right]) && Math.abs(left-right) <= k){
                return true;
            }

            if(!set.contains(nums[right])){
                set.add(nums[right]);
            }

            right++;
        }

        return false;
    }
}