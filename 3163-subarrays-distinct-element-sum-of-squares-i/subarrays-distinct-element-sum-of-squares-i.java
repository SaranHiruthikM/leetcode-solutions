class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.size(); i++){
            set = new HashSet<>();
            for(int j=i; j<nums.size(); j++){
                set.add(nums.get(j));
                sum+= (set.size() * set.size());
            }
        }
        return sum;
    }

}