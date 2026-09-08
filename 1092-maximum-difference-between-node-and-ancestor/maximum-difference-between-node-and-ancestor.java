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
    int diff = 0;
    private void dfs(TreeNode root, int min, int max){
        if(root == null) return;

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff = Math.max(diff, Math.abs(min-max));

        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return diff;
    }
}