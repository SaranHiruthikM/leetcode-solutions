import java.util.*;

class Solution {

    public void backtrack(int ind, int[] arr, int target,
                          List<List<Integer>> ans,
                          List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {

            // 🔥 Skip duplicates at same recursion level
            if (i > ind && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;  // pruning (since sorted)

            ds.add(arr[i]);
            backtrack(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);  // backtrack
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);  // IMPORTANT

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}