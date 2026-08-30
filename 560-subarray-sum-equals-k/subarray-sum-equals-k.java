class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int result = 0;
        map.put(0, 1);
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            int needSum = currSum - k;
            if(map.containsKey(needSum)){
                result+=map.get(needSum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return result;
    }
}