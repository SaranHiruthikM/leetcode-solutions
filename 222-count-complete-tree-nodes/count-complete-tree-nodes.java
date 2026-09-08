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
    private int getLeftHeight(TreeNode root){
        int count = 0;
        while(root != null){
            root = root.left;
            count++;
        }

        return count;
    }

    private int getRightHeight(TreeNode root){
        int count = 0;
        while(root != null){
            root = root.right;
            count++;
        }

        return count;
    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if(lh == rh){
            return (1 << lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}