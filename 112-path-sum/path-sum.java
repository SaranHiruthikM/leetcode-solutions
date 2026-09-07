class Solution {

    private boolean dfs(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // If leaf, check whether we completed the sum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return dfs(root.left, targetSum - root.val)
                || dfs(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
}