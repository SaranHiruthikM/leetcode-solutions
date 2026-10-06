class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int times = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(val == 1) return -1;

            if(val % 3 == 0){
                times += val/3;
            }else {
                times += val/3 + 1;
            }
        }

        return times;
    }
}