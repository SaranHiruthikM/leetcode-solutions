class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] diff = new int[n];
        for(int i=0; i<n; i++){
            diff[i] = target[i] - nums[i];
        }
        long minOps = 0;
        int curr = 0;
        int prev = 0;
        for(int i=0; i<n; i++){
            curr = diff[i];

            if((curr > 0 && prev < 0) || (curr < 0 && prev > 0)){
                minOps += (long) Math.abs(curr);
            }else{
                if(curr > 0 && curr > prev){
                    minOps += (long) Math.abs(curr-prev);
                }else if(curr < 0 && curr < prev){
                    minOps += (long) Math.abs(curr-prev);
                }
            }

            prev = curr;
        }

        return minOps;
    }
}