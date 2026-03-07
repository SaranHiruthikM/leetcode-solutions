class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void helper(int k, int target, int i, List<Integer> arr){
        if(arr.size() == k && target == 0){
            res.add(new ArrayList<>(arr));
            return;
        }

        if(i > 9) return;
        if(target < 0) return;
        if(target == 0 && arr.size() != k) return;
        if(arr.size() == k && target != 0) return;
        
        arr.add(i); 
        helper(k, target - i, i+1, arr);
        arr.remove(arr.size() - 1);
        helper(k, target, i+1, arr);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> arr =  new ArrayList<>();
        helper(k, n, 1,arr);
        return res;
    }
}