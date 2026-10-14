class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ancestors.add(new HashSet<>());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                ancestors.get(v).add(u);
                ancestors.get(v).addAll(ancestors.get(u));

                if (--indegree[v] == 0)
                    q.offer(v);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (Set<Integer> set : ancestors) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            ans.add(list);
        }

        return ans;
    }
}