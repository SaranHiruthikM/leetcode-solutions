class Solution {
    List<List<Integer>> res = new ArrayList<>();
    private void dfs(int[][] graph, int src, List<Integer> temp){
        temp.add(src);
        if(src == graph.length-1){
            res.add(new ArrayList<>(temp));
        }else{
            for(int v : graph[src]){
                dfs(graph, v, temp);
            }
        }
        
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new ArrayList<>());
        return res;
    }
}