class Solution {
    public int minRange(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        while(arr[0]+arr[1] < arr[2]){
            arr[2] = arr[0]+arr[1];
        }
        return arr[2] - arr[0];
    }
}