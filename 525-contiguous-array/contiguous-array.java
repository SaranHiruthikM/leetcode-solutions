class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                currSum -= 1;
            }else{
                currSum += 1;
            }
            if(map.containsKey(currSum)){
                int dist = i - map.get(currSum);
                len = Math.max(len, dist);
            }else{
                map.put(currSum, i);
            }
        }

        return len;
    }
}