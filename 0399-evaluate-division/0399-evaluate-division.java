class Solution {
    HashMap<String, List<Pair<String, Double>>> adj = new HashMap<>();
    double ans;
    private void dfs(String src, String dst, HashSet<String> vis, double product){
        if(vis.contains(src)) return;

        vis.add(src);

        if(src.equals(dst)){
            ans = product;
            return;
        }

        for(Pair<String, Double> v : adj.getOrDefault(src, new ArrayList<>())){
            dfs(v.getKey(), dst, vis, product*v.getValue());
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0; i<equations.size(); i++){
            adj.computeIfAbsent(equations.get(i).get(0), k -> new ArrayList<>()).add(new Pair<>(equations.get(i).get(1), values[i]));
            adj.computeIfAbsent(equations.get(i).get(1), k -> new ArrayList<>()).add(new Pair<>(equations.get(i).get(0), 1.0/values[i]));
        }

        double res[] = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            ans = -1.0;

            if(adj.containsKey(src)) dfs(src, dst, new HashSet<>(), 1.0);

            res[i] = ans;
        }

        return res;
    }
}