class Solution {

    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    int result = 1;

    private int dfs(int curr, int parent, String s) {

        int longest = 0;
        int secondLongest = 0;

        for (int child : adj.getOrDefault(curr, new ArrayList<>())) {

            if (child == parent)
                continue;

            int childLength = dfs(child, curr, s);

            // Adjacent characters must be different
            if (s.charAt(child) == s.charAt(curr))
                continue;

            if (childLength > longest) {
                secondLongest = longest;
                longest = childLength;
            }
            else if (childLength > secondLongest) {
                secondLongest = childLength;
            }
        }

        // Path passing through curr using two children
        result = Math.max(
            result,
            1 + longest + secondLongest
        );

        // Return longest downward path starting at curr
        return 1 + longest;
    }

    public int longestPath(int[] parent, String s) {

        for (int i = 1; i < parent.length; i++) {

            adj.computeIfAbsent(i, k -> new ArrayList<>())
               .add(parent[i]);

            adj.computeIfAbsent(parent[i], k -> new ArrayList<>())
               .add(i);
        }

        dfs(0, -1, s);

        return result;
    }
}