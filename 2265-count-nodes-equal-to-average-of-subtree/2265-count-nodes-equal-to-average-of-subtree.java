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
    int count = 0;
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int leftSubtree[] = dfs(root.left);
        int rightSubtree[] = dfs(root.right);

        int cnt = leftSubtree[1] + rightSubtree[1] + 1;
        int sum = leftSubtree[0] + rightSubtree[0] + root.val;

        if(root.val == (sum/cnt)){
            count++;
        }
        
        return new int[]{sum, cnt};
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);

        return count;
    }
}