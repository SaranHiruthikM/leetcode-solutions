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
    long totSum = 0;
    long maxProd = 0;
    long mod = 1_000_000_007L;

    private long sum(TreeNode root){
        if(root == null){
            return 0;
        }

        return root.val + sum(root.left) + sum(root.right);
    }

    private long dfs(TreeNode root){
        if(root == null) return 0;
        long leftSum = dfs(root.left);
        long rightSum = dfs(root.right);
        long sum = leftSum + rightSum + root.val;
        long subtreeSum = totSum - sum;
        maxProd = Math.max(maxProd, sum * subtreeSum);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        totSum = sum(root);
        
        dfs(root);

        return (int) (maxProd % mod);
    }
}