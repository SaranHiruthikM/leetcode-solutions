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
    public String smallestFromLeaf(TreeNode root) {
        Queue<Pair<TreeNode, String>> q = new LinkedList<>();
        q.offer(new Pair<>(root, "" + (char)('a' + root.val)));
        String result = null;
        while(!q.isEmpty()){
            Pair<TreeNode, String> curr = q.poll();
            TreeNode node = curr.getKey();
            String str = curr.getValue();
            if(node.left == null && node.right == null){
                if (result == null || result.compareTo(str) > 0) {
                    result = str;
                }
            }
            if(node.left != null) q.offer(new Pair<>(node.left,  (char) (node.left.val + 'a') + str));
            if(node.right != null) q.offer(new Pair<>(node.right, (char) (node.right.val + 'a') + str));
        }

        return result;
    }
}