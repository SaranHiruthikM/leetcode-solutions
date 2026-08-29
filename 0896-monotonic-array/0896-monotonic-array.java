class Solution {
    public boolean isMonotonic(int[] arr) {
        boolean increasing = true;
        boolean decreasing = true;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[i-1]){
                decreasing = false;
            }
            
            if(arr[i] < arr[i-1]){
                increasing = false;
            }
        }

        return increasing || decreasing;
    }
}