class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        int i = 0;
        int last = -1;
        while( i < nums.length){
            int start = i;
            while(i < nums.length-1 && nums[i+1] == nums[i]+1){
                last = i+1;
                i++;
            }

            if(last == -1){
                res.add(String.valueOf(nums[start]));
            }else if(last - start > 0){
                res.add(String.format("%d->%d", nums[start], nums[last]));
            }

            last = -1;
            i++;
        }

        return res;
    }
}