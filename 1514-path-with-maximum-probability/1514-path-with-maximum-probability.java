class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        HashMap<Integer, List<double[]>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new double[]{v, p});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new double[]{u, p});
        }
        double prob[] = new double[n];
        pq.add(new double[]{1, start_node});
        prob[start_node] = 1;
        while(!pq.isEmpty()){
            double curr[] = pq.poll();
            int u = (int) curr[1];
            double p = curr[0];
            for(double[] neighbour : adj.getOrDefault(u, new ArrayList<>())){
                int v = (int) neighbour[0];
                double d = neighbour[1];

                if(d*p > prob[v]){
                    prob[v] = d*p;
                    pq.offer(new double[]{prob[v], v});
                }
            }
        }

        return prob[end_node];
    }
}