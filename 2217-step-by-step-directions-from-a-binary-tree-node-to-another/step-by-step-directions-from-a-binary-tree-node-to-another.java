class Solution {

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) return false;

        if (root.val == target) return true;

        // Try left
        path.append('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        // Try right
        path.append('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);

        // Find common path from root
        int i = 0;
        while (i < startPath.length()
                && i < destPath.length()
                && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        // From start node, go up to the common ancestor
        StringBuilder result = new StringBuilder();

        for (int j = i; j < startPath.length(); j++) {
            result.append('U');
        }

        // From common ancestor, go down to destination
        result.append(destPath.substring(i));

        return result.toString();
    }
}