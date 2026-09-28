 class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();

    private boolean isSimilar(String str1, String str2) {
        int diff = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }

        return diff == 2 || diff == 0;
    }

    private void dfs(boolean[] vis, int node) {
        vis[node] = true;

        for (int v : adj.getOrDefault(node, new ArrayList<>())) {
            if (!vis[v]) {
                dfs(vis, v);
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        int grp = 0;
        boolean[] vis = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (!vis[i]) {
                dfs(vis, i);
                grp++;
            }
        }

        return grp;
    }
}