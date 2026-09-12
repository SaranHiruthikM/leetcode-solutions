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
    private boolean flipEq(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        
        if (root1 == null || root2 == null){
            return false;
        }

        if(root1.val == root2.val){
            boolean withFlip = flipEq(root1.left, root2.right) && flipEq(root1.right, root2.left);
            boolean withoutFlip = flipEq(root1.left, root2.left) && flipEq(root1.right, root2.right);
            return withFlip || withoutFlip;
        }

        return false;
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flipEq(root1, root2);
    }
}