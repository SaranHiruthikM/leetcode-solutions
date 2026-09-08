/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    private String solve(TreeNode root){
        if(root == null){
            return "N";
        }

        String s = root.val + "," + solve(root.left) + "," + solve(root.right) + ",";

        if(map.getOrDefault(s, 0) == 1){
            res.add(root);
        }

        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return res;
    }
}