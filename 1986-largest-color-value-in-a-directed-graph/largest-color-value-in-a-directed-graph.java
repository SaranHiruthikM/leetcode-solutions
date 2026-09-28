class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        int[] indeg = new int[n];

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            indeg[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        int[][] dp = new int[n][26];

        // All nodes with indegree 0 can start a path
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int answer = 0;
        int countNodes = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            countNodes++;

            // Find the best color value for a path ending at curr
            for (int i = 0; i < 26; i++) {
                answer = Math.max(answer, dp[curr][i]);
            }

            for (int v : adj.getOrDefault(curr, new ArrayList<>())) {

                // Pass the best color counts from curr to v
                for (int i = 0; i < 26; i++) {
                    dp[v][i] = Math.max(
                        dp[v][i],
                        dp[curr][i] + (colors.charAt(v) - 'a' == i ? 1 : 0)
                    );
                }

                indeg[v]--;

                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Not all nodes processed => cycle exists
        if (countNodes < n) {
            return -1;
        }

        return answer;
    }
}