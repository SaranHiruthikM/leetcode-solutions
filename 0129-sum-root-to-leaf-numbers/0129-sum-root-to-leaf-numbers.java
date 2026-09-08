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
    List<Integer> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    private void dfs(TreeNode root){
        if(root == null) return;
        sb.append(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            if(!sb.toString().equals("")) res.add(Integer.parseInt(sb.toString()));
        }
        
        dfs(root.left);
        dfs(root.right);
        if(!sb.toString().equals("")) sb.setLength(sb.length()-1);
    }
    public int sumNumbers(TreeNode root) {
        dfs(root);
        int sum = 0;
        for(int num : res){
            sum += num;
        }

        return sum;
    }
}