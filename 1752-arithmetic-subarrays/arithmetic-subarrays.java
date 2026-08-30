class Solution {
    private boolean check(int[] nums, int left, int right){
        Set<Integer> set = new HashSet<>();
        int mini = Integer.MAX_VALUE;        
        int maxi = Integer.MIN_VALUE;
        for(int i=left; i<=right; i++){
            maxi = Math.max(maxi, nums[i]);
            mini = Math.min(mini, nums[i]);
            set.add(nums[i]);
        }

        int len = right - left + 1;

        if((maxi-mini) % (len - 1) != 0){
            return false;
        }
        int diff = (maxi - mini) / (len -1);
        
        for(int i=0; i<len; i++){
            int expected = mini + (i)*diff;

            if(!set.contains(expected)){
                return false;
            }
        }

        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<l.length; i++){
            if(check(nums, l[i], r[i])){
                res.add(true);
            }else{
                res.add(false);
            }
        }

        return res;
    }
}