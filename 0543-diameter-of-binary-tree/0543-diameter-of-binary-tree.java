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
    int dia = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = dfs(root.left);
        int rh = dfs(root.right);

        dia = Math.max(dia, lh + rh);

        return Math.max(lh, rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return dia;
    }
}