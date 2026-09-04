class Solution {
    int[] parent;
    int[] rank;

    private int find(int i){
        if(i == parent[i]){
            return parent[i];
        }

        return parent[i] = find(parent[i]);
    }

    private void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[x_parent] = y_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        int L = connections.length;

        if(L < n-1){
            return -1;
        }
        
        int components = n;

        for(int conn[] : connections){
            int x_parent = find(conn[0]);
            int y_parent = find(conn[1]);

            if(x_parent == y_parent){
                continue;
            }

            union(x_parent, y_parent);
            n--;
        }

        return n-1;
    }
}