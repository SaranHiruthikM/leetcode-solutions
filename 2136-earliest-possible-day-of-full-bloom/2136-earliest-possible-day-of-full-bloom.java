class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i] = new int[]{plantTime[i], growTime[i]};
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

        int maxBloomDays = 0;
        int prevPlantDays = 0;
        for(int i=0; i<n; i++){
            prevPlantDays += arr[i][0];
            int bloomDays = prevPlantDays + arr[i][1];
            maxBloomDays = Math.max(maxBloomDays, bloomDays);
        }

        return maxBloomDays;
    }
}