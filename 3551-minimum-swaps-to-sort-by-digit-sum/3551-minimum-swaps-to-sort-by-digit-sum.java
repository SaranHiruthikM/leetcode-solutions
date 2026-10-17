class Solution {
    private int sum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int process[][] = new int[n][3];
        for(int i=0; i<n; i++){
            process[i] = new int[]{sum(nums[i]), nums[i], i};
        }
        Arrays.sort(process, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            if (cmp == 0)
                return Integer.compare(a[1], b[1]);
            return cmp;
        });
        boolean isSame = false;
        for(int i=0; i<n; i++){
            if(process[i][2] != i){
                isSame = true;
            }
        }
        
        boolean[] visited = new boolean[n];
        int minSwaps = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            int curr = i;
            int cycleSize = 0;

            while(!visited[curr]) {
                visited[curr] = true;
                cycleSize++;
                curr = process[curr][2];
            }

            if(cycleSize > 1) {
                minSwaps += cycleSize - 1;
            }
        }

        return minSwaps;
    }
}