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
    private TreeNode dfs(TreeNode root, int val, int depth){
        if(root == null) return null;

        if(depth == 1){
            TreeNode tempL = root.left;
            TreeNode tempR = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = tempL;
            root.right.right = tempR;
            return root;
        }

        dfs(root.left, val, depth-1);
        dfs(root.right, val, depth-1);

        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        return dfs(root, val, depth-1);
    }
}