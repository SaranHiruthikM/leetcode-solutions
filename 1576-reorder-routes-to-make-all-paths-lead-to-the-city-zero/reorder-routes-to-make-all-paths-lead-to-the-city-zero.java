class Solution {
    HashMap<Integer, List<Integer>> adj2 = new HashMap<>();
    HashMap<Integer, Set<Integer>> adj1 = new HashMap<>();
    int cnt = 0;
    private void dfs(int src, int parent){
        for(int neighbours : adj2.getOrDefault(src, new ArrayList<>())){
            if(neighbours == parent) continue;
            dfs(neighbours, src);
        }

        if(parent != -1 && adj1.get(parent) != null && adj1.get(parent).contains(src)){
            cnt++;
        }
    }
    public int minReorder(int n, int[][] connections) {
        for(int connection[] : connections){
            int u = connection[0];
            int v = connection[1];
            adj1.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            adj2.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj2.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        dfs(0, -1);
        return cnt;
    }
}