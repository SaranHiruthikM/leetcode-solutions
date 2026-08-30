class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] map = new int[200+1];
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int freq = map[nums[i]];
            if(freq == res.size()){
                res.add(new ArrayList<>());
            }

            res.get(freq).add(nums[i]);
            map[nums[i]]++;
        }

        return res;
    }
}