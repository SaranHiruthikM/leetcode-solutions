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
    HashMap<TreeNode, int[]> map = new HashMap<>();
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);
        if(root.left == null && root.right == null){
            map.put(root, new int[]{root.val, 1});
        }else{
            int count = 0;
            int sum = 0;
            if(map.containsKey(root.left)){
                int[] curr = map.get(root.left);
                count += curr[1];
                sum += curr[0];
            }

            if(map.containsKey(root.right)){
                int[] curr = map.get(root.right);
                count += curr[1];
                sum += curr[0];
            }
                
            map.put(root, new int[]{root.val + sum, count+1});
        }

        
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        int count = 0;
        for (Map.Entry<TreeNode, int[]> entry : map.entrySet()) {
            if(entry.getKey().val == (entry.getValue()[0]/entry.getValue()[1])){
                count++;
            }
        }

        return count;
    }
}