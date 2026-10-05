class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalEarn = Arrays.stream(gas).sum();
        int totalSpend = Arrays.stream(cost).sum();

        if(totalSpend > totalEarn) return -1;
        int total = 0;
        int result = 0;
        for(int i=0; i<n; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                result = i+1;
            }
        }
        return result;
    }
}