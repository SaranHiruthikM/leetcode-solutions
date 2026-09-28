class DSU {
    int[] parent;
    int[] rank;
    int components;

    public DSU(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        components = n;
    }
    int find (int x) {
        if (x == parent[x]) 
            return x;

        return parent[x] = find(parent[x]);
    }

    void Union (int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent) 
            return;

        if(rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if(rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
        components--;
    }
}

class Solution {
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

        int edgeCount = 0;

        for(int edge[] : edges){
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            boolean addedEdge = false;
            if(type == 3){
                if(alice.find(u) != alice.find(v)){
                    alice.Union(u, v);
                    addedEdge = true;
                }

                if(bob.find(u) != bob.find(v)){
                    bob.Union(u, v);
                    addedEdge = true;
                }

                if(addedEdge) edgeCount++;
            }else if(type == 1){
                if(alice.find(u) != alice.find(v)){
                    alice.Union(u, v);
                    edgeCount++;
                }
            }else{
                if(bob.find(u) != bob.find(v)){
                    bob.Union(u, v);
                    edgeCount++;
                }
            }
        }

        return (alice.components == 1 && bob.components == 1) ? edges.length - edgeCount : -1;
    }
}