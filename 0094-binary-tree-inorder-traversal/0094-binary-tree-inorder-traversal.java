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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode IP = curr.left;
                while(IP.right != null && IP.right != curr){
                    IP = IP.right;
                }

                if(IP.right == null){
                    IP.right = curr;
                    curr = curr.left;
                }else{
                    IP.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}