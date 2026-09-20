class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0, right = 0, maxSatisfaction = 0, currSatisfaction = 0;
        for(int i=0; i<customers.length; i++){
            currSatisfaction += (grumpy[i] == 0) ? customers[i] : 0;
        }

        while(right < customers.length){
            currSatisfaction += (grumpy[right] == 1) ? customers[right] : 0;
            if(right-left+1 == minutes){
                maxSatisfaction = Math.max(maxSatisfaction, currSatisfaction);
                currSatisfaction -= (grumpy[left] == 1) ? customers[left] : 0;
                left++;
            }
            right++;
        }

        return maxSatisfaction;
    }
}