class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int round = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getValue();

            if(val == 1) return -1;

            if(val % 3 == 0){
                round += val/3;
            }else{
                round += val/3 +1;
            }
        }

        return round;
    }
}