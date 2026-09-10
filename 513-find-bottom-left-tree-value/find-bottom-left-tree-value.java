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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode prev = null;
        while(!q.isEmpty()){
            int size = q.size();
            int cnt = 1;
            while(size > 0){
                TreeNode curr = q.poll();
                if(cnt == 1){
                    prev = curr;
                }
                cnt++;

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                size--;
            }
        }

        return prev.val;
    }
}