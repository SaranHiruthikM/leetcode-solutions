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
    private TreeNode dfs(TreeNode root){
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            if(root.val == 0){
                return null;
            }

            return root;
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if(root.left == null && root.right == null){
            if(root.val == 0){
                return null;
            }
        }

        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }
}