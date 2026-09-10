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
    private void dfs(TreeNode root, int[] temp){
        if(root == null) return;
        temp[root.val-1]++;
        
        if(root.left == null && root.right == null){
            int oddCount = 0;
            for(int i=0; i<9; i++){
                if(temp[i] % 2 != 0){
                    oddCount++;
                }   
            }

            if(oddCount <= 1){
                totCount++;
            }
        }

        dfs(root.left, temp);
        dfs(root.right, temp);

        temp[root.val-1]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root.left == null && root.right == null) return 1;
        dfs(root, new int[9]);
        return totCount;
    }
}