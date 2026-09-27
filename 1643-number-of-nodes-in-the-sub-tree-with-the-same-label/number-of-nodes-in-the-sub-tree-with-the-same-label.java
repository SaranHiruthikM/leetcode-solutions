class Solution {
    int res[];
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    int cnt[] = new int[26];
    private void dfs(int node, int parent, HashMap<Integer, List<Integer>> adj, String labels){
        char currLabel = labels.charAt(node);
        int before = cnt[currLabel - 'a'];
        cnt[currLabel - 'a']++;

        for(int neighbours : adj.get(node)){
            if(neighbours != parent){
                dfs(neighbours, node, adj, labels);
            }
        }

        int after = cnt[currLabel - 'a'];
        res[node] = after - before;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        if(edges.length == 0) return new int[]{n};
        res = new int[n];
        for(int edge[] : edges){
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        dfs(0, -1, adj, labels);
        return res;
    }
}