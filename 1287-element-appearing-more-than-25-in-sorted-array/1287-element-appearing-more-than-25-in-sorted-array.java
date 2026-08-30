class Solution {
    public int findSpecialInteger(int[] arr) {
        int winner = arr[0];
        int target = arr.length/4;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == winner){
                count++;
            }else{
                winner = arr[i];
                count = 1;
            }

            if(count > target){
                return winner;
            }
        }

        return winner;
    }
}