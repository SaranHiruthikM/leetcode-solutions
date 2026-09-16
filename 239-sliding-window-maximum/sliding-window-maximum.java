class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            while(!q.isEmpty() && q.getFirst() <= i-k){
                q.removeFirst();
            }

            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]){
                q.removeLast();
            }

            q.addLast(i);

            if(i >= k-1){
                res.add(nums[q.getFirst()]);
            }

        }
        int idx = 0;
        int[] result = new int[res.size()];
        for(int num : res){
            result[idx++] = num;
        }

        return result;
    }
}