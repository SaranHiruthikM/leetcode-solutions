/**
 * Definition for a binary tree root.
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
    List<TreeNode>  res = new ArrayList<>();
    private TreeNode dfs(TreeNode root, Set<Integer> set){
        if(root == null){
            return null;
        }

        root.left = dfs(root.left, set);
        root.right = dfs(root.right, set);

        if(set.contains(root.val)){
            if(root.left != null) res.add(root.left);

            if(root.right != null) res.add(root.right);

            return null;
        }else{
            return root;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

        dfs(root, set);

        if(!set.contains(root.val)){
            res.add(root);
        }

        return res;
    }
}