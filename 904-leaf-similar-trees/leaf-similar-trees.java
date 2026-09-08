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
    List<Integer> lst1 = new ArrayList<>();
    List<Integer> lst2 = new ArrayList<>();
    private void left(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            lst1.add(root.val);
        }

        left(root.left);
        left(root.right);
    }

    private void right(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            lst2.add(root.val);
        }

        right(root.left);
        right(root.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        left(root1);
        right(root2);
        return lst1.equals(lst2);
    }
}