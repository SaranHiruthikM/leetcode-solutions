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
    List<Integer> levelSum = new ArrayList<>();
    private void getLevelSum(TreeNode root, int depth){
        if(root == null) return;

        if(depth == levelSum.size()){
            levelSum.add(root.val);
        }else{
            int alreadyVal = levelSum.get(depth);
            levelSum.set(depth, alreadyVal + root.val);
        }

        getLevelSum(root.left, depth+1);
        getLevelSum(root.right, depth+1);
    }

    private void updateTree(TreeNode root, int depth){
        if(root == null) return;

        int childrenSum = 0;
        childrenSum += (root.left != null) ? root.left.val : 0;
        childrenSum += (root.right != null) ? root.right.val : 0;

        if(root.left != null){
            root.left.val = levelSum.get(depth+1) - childrenSum;
        }

        if(root.right != null){
            root.right.val = levelSum.get(depth+1) - childrenSum;
        }

        updateTree(root.left, depth+1);
        updateTree(root.right, depth+1);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        getLevelSum(root, 0);
        updateTree(root, 0);
        root.val = 0;
        return root;
    }
}