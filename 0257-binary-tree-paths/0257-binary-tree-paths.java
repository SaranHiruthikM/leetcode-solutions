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
    List<String> ans = new ArrayList<>();
    public void helper(TreeNode root, String path){
        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        if (root.left != null) helper(root.left, path + "->" + String.valueOf(root.left.val));
        if(root.right != null) helper(root.right, path + "->" + String.valueOf(root.right.val));

    }

    public List<String> binaryTreePaths(TreeNode root) {
        String path = String.valueOf(root.val);
        helper(root, path);
        return ans;
    }
}