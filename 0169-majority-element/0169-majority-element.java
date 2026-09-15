class Solution {
    public int majorityElement(int[] nums) {
        int maxEle = -1;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                maxEle = num;
                count = 1;
                continue;
            }

            if(maxEle == num){
                count++;
            }else{
                count--;
            }
        }

        return maxEle;
    }
}