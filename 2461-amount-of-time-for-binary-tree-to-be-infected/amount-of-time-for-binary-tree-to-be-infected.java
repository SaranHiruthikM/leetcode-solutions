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
    int max = Integer.MIN_VALUE;
    private int dfs(TreeNode root, int start){
        if(root == null) return 0;

        int lh = dfs(root.left, start);
        int rh = dfs(root.right, start);

        if(root.val == start){
            max = Math.max(lh, rh);
            return -1;
        }else if(lh >= 0 && rh >= 0){
            return Math.max(lh, rh) + 1;
        }else{
            int d = Math.abs(lh) + Math.abs(rh);
            max = Math.max(max, d);
            return Math.min(lh, rh) - 1;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return max;
    }
}