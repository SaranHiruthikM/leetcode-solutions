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
    int minDepth = Integer.MAX_VALUE;
    private int dfs(TreeNode root, int depth){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth, depth);
            return 0;
        }

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
        
        return depth;
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 1);
        return minDepth;
    }
}