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

class Pair {
    TreeNode  node;
    long idx;

    Pair(TreeNode node, long val){
        this.node = node;
        this.idx = val;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            long first = q.peek().idx;
            long last = first;
            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                last = curr.idx;
                long idx = curr.idx;
                if(curr.node.left != null){
                    q.offer(new Pair(curr.node.left, 2*idx));
                }
                if(curr.node.right != null){
                    q.offer(new Pair(curr.node.right, 2*idx+1));
                }
            }

            int width = (int)(last - first +1);
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }
}