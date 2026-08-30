class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(new int[] { 0, 0 });
        while (!q.isEmpty()) {

            int curr[] = q.poll();
            int row = curr[0];
            int col = curr[1];
            res.add(nums.get(row).get(col));
                if (col == 0 && row + 1 < nums.size()) {
                    q.offer(new int[] { row + 1, col });
                }

                if (col+1 < nums.get(row).size()) {
                    q.offer(new int[] { row, col + 1 });
                }
            
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}