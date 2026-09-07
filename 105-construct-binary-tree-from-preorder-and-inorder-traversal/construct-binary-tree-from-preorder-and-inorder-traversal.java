class Solution {

    private int idx = 0;

    private TreeNode build(
            int[] preorder,
            int[] inorder,
            int left,
            int right) {

        // Empty range
        if (left > right) {
            return null;
        }

        // Next preorder value is the root
        int rootVal = preorder[idx++];

        TreeNode root = new TreeNode(rootVal);

        // Find root in the CURRENT inorder range
        int rootIndex = left;

        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        // Build left completely first
        root.left = build(preorder, inorder, left, rootIndex - 1);

        // idx is now automatically at the correct position
        root.right = build(preorder, inorder, rootIndex + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, inorder, 0, inorder.length - 1);
    }
}