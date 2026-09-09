class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0L));

        long maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            long first = q.peek().getValue();
            long last = first;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> curr = q.poll();

                TreeNode node = curr.getKey();
                long index = curr.getValue();

                // Normalize index to avoid overflow
                index -= first;
                last = index;

                if (node.left != null) {
                    q.offer(new Pair<>(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair<>(node.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last + 1);
        }

        return (int) maxWidth;
    }
}