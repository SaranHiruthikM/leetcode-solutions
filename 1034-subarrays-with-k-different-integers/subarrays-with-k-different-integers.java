class Solution {
    private int subarrayLessThanK(int[] nums, int k){
        int left = 0, right = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while( map.size() > k){
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            cnt += (right - left +1);
            right++;
        }

        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayLessThanK(nums, k) - subarrayLessThanK(nums, k-1);
    }
}