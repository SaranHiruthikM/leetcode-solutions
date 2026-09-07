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
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return dfs(root, 0, totalNodes);
    }

    private int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean dfs(TreeNode root, int node, int totalNodes){
        if(root == null){
            return true;
        }

        if(node >= totalNodes){
            return false;
        }

        return dfs(root.left, 2*node + 1, totalNodes) && dfs(root.right, 2*node + 2, totalNodes);
    }
}