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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int lowLevel = 1;
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int locSum = 0;
            while(size-- > 0){
                TreeNode currNode = q.poll();
                locSum += currNode.val;

                if(currNode.left != null){
                    q.offer(currNode.left);
                }

                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
            if(locSum > maxSum){
                maxSum = locSum;
                lowLevel = level;
            }
            level++;
        }

        return lowLevel;
    }
}