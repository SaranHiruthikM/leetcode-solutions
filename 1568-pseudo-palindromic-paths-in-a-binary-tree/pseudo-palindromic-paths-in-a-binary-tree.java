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
    int totCount = 0;
    private void dfs(TreeNode root, int val){
        if(root == null) return;
        
        val = (val ^ (1 << root.val));
        
        if(root.left == null && root.right == null){
            if((val & (val - 1)) == 0){
                totCount++;
            }
        }

        dfs(root.left, val);
        dfs(root.right, val);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return totCount;
    }
}