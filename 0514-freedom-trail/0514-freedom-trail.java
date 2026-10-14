class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int INF = 1000000;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
            dist[i][(i + 1) % n] = 1;
            dist[i][(i - 1 + n) % n] = 1;
        }

        // Floyd-Warshall: minimum rotations between all positions
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(
                        dist[i][j],
                        dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        // dp[position] = minimum cost to finish the processed key
        // with the ring pointing at this position
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < key.length(); i++) {
            int[] next = new int[n];
            Arrays.fill(next, INF);

            for (int pos = 0; pos < n; pos++) {
                if (dp[pos] == INF) continue;

                for (int target = 0; target < n; target++) {
                    if (ring.charAt(target) == key.charAt(i)) {
                        next[target] = Math.min(
                            next[target],
                            dp[pos] + dist[pos][target] + 1
                        );
                    }
                }
            }

            dp = next;
        }

        int ans = INF;
        for (int cost : dp) {
            ans = Math.min(ans, cost);
        }

        return ans;
    }
}