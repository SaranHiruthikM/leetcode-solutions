class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int res = 0;
        map.put(0,1 );
        for(int num : arr){
            currSum += num;
            int needed = currSum - goal;
            if(map.containsKey(needed)){
                res += map.get(needed);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return res;
        
// int left = 0;
//         int right = 0;
//         int sum = 0;
//         int count = 0;
//         while(right < arr.length){
//             sum += arr[right];
//             if(sum > goal){
//                 while(sum > goal){
//                     sum -= arr[left];
//                     left++;
//                 }
//             }
//             if(sum == goal) count++;
//             right++;
//         }
//         return count;
    }
}