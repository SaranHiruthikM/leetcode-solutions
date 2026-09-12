class Solution {

    HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
    Set<TreeNode> leaves = new HashSet<>();

    private void buildGraph(TreeNode root, TreeNode parent) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            leaves.add(root);
        }

        if (parent != null) {
            graph.computeIfAbsent(root, k -> new ArrayList<>()).add(parent);
            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(root);
        }

        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }

    public int countPairs(TreeNode root, int distance) {

        // Convert tree into an undirected graph
        buildGraph(root, null);

        int count = 0;

        // BFS from every leaf
        for (TreeNode leaf : leaves) {

            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();

            q.offer(leaf);
            visited.add(leaf);

            int dist = 0;

            while (!q.isEmpty() && dist <= distance) {

                int size = q.size();

                while (size-- > 0) {
                    TreeNode curr = q.poll();

                    // Found another leaf
                    if (curr != leaf && leaves.contains(curr)) {
                        count++;
                    }

                    for (TreeNode next : graph.getOrDefault(curr, new ArrayList<>())) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }

                dist++;
            }
        }

        // Every pair was counted twice
        return count / 2;
    }
}