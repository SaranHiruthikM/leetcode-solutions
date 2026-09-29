class Solution {
    int N;
    class UnionFind{
        int parent[];
        int rank[];

        public UnionFind(int n){
            parent = new int[n];
            for(int i=0; i<n; i++) parent[i] = i;
            rank = new int[n];
        }

        public int find (int x) {
            if (x == parent[x]) 
                return x;

            return parent[x] = find(parent[x]);
        }

        public boolean Union (int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) 
                return false;

            if(rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if(rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
            return true;
        }
    }
    private int kruskal(int[][] newEdges, int skipEdge, int addEdge){
        int sum = 0;
        UnionFind uf = new UnionFind(N);
        int edgesConnected = 0;
        if(addEdge != -1){
            uf.Union(newEdges[addEdge][0], newEdges[addEdge][1]);
            sum += newEdges[addEdge][2];
            edgesConnected++;
        }
        for(int i=0; i<newEdges.length; i++){
            if(i == skipEdge) continue;
            int u = newEdges[i][0];
            int v = newEdges[i][1];
            int d = newEdges[i][2];

            int parent_u = uf.find(u);
            int parent_v = uf.find(v);

            if(parent_u != parent_v){
                uf.Union(u, v);
                sum += newEdges[i][2];
                edgesConnected++;
            }
        }

        if(edgesConnected != N-1){
            return Integer.MAX_VALUE;
        }

        return sum;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        N = n;
        int[][] newEdges = new int[edges.length][edges[0].length+1];
        for(int i=0; i<newEdges.length; i++){
            newEdges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(newEdges, (a, b) -> Integer.compare(a[2], b[2]));

        int MST_WEIGHT = kruskal(newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<newEdges.length; i++){
            if(kruskal(newEdges, i, -1) > MST_WEIGHT) critical.add(newEdges[i][3]);
            else if(kruskal(newEdges, -1, i) == MST_WEIGHT) pseudoCritical.add(newEdges[i][3]);
        }

        res.add(critical);
        res.add(pseudoCritical);
        return res;
    }
}