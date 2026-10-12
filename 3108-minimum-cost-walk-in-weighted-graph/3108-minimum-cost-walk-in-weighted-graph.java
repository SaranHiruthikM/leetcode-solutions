class Solution {
    int parent[];

    private int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    private void Union(int x, int y){
        parent[y] = x;
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        int cost[] = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            cost[i] = -1;
        }

        for(int[] edge :edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int parent_u = find(u);
            int parent_v = find(v);

            if(parent_u != parent_v){
                Union(parent_u, parent_v);
                cost[parent_u] &= cost[parent_v];
            }

            cost[parent_u] &= w;
        }

        int[] result = new int[query.length];
        for(int i=0; i<query.length; i++){
            int s = query[i][0];
            int t = query[i][1];
            int parent_s = find(s);
            int parent_t = find(t);
            if(s == t){
                result[i] = 0;
            }else if(parent_s != parent_t){
                result[i] = -1;
            }else{
                result[i] = cost[parent_s];
            }
        }

        return result;
    }
}