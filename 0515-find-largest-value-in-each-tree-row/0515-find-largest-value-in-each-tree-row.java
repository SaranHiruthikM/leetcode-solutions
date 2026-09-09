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
    private void dfs(TreeNode root,int depth){
        if(root == null) return;

        if(depth >= res.size()){
            res.add(depth, root.val); 
        }else if(res.get(depth) < root.val){
            res.set(depth, root.val);
        }

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return res;
    }
}