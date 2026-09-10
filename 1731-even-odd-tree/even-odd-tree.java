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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEven = true;
        while(!q.isEmpty()){
            int size = q.size(); 
            int prev = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(size-- > 0){
                TreeNode curr = q.poll();
                if(isEven){
                    if(curr.val % 2 != 0 && curr.val > prev){
                        if(curr.left != null) q.offer(curr.left);
                        if(curr.right != null) q.offer(curr.right);
                    }else{
                        return false;
                    }
                }else{
                    if(curr.val % 2 == 0 && curr.val < prev){
                        if(curr.left != null) q.offer(curr.left);
                        if(curr.right != null) q.offer(curr.right);
                    }else{
                        return false;
                    }
                }
                prev = curr.val;
            }
            isEven = !isEven;
        }

        return true;
    }
}