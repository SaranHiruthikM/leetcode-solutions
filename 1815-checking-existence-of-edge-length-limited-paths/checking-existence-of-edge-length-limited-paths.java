class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    void Union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent)
            return;

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public boolean[] distanceLimitedPathsExist(
            int n, int[][] edgeList, int[][] queries) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        // {u, v, limit, originalIndex}
        int[][] sortedQueries = new int[queries.length][4];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = queries[i][2];
            sortedQueries[i][3] = i;
        }

        Arrays.sort(sortedQueries,
                (a, b) -> Integer.compare(a[2], b[2]));

        boolean[] ans = new boolean[queries.length];

        int edgeIndex = 0;

        for (int i = 0; i < sortedQueries.length; i++) {

            int u = sortedQueries[i][0];
            int v = sortedQueries[i][1];
            int limit = sortedQueries[i][2];
            int originalIndex = sortedQueries[i][3];

            // Add all edges with weight < limit
            while (edgeIndex < edgeList.length &&
                   edgeList[edgeIndex][2] < limit) {

                int x = edgeList[edgeIndex][0];
                int y = edgeList[edgeIndex][1];

                Union(x, y);

                edgeIndex++;
            }

            ans[originalIndex] = find(u) == find(v);
        }

        return ans;
    }
}