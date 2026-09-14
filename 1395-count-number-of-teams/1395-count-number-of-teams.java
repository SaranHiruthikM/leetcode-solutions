class Solution {
    public int numTeams(int[] arr) {
        int n = arr.length;
        int teams = 0;
        for(int j=0; j<n; j++){
            int countSmallerLeft = 0;
            int countSmallerRight = 0;
            int countLargerLeft = 0;
            int countLargerRight = 0;

            for(int i=0; i<j; i++){
                if(arr[i] < arr[j]){
                    countSmallerLeft++;
                }else if(arr[i] > arr[j]){
                    countLargerLeft++;
                }
            }

            for(int i=n-1; i>j; i--){
                if(arr[i] < arr[j]){
                    countSmallerRight++;
                }else if(arr[i] > arr[j]){
                    countLargerRight++;
                }
            }

            teams += (countSmallerLeft * countLargerRight) + (countLargerLeft * countSmallerRight);
        }

        return teams;
    }
}