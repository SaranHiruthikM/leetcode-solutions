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

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        int components = n;

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int edge[] : edges){
            int x_parent = find(edge[0]);
            int y_parent = find(edge[1]);

            if(x_parent == y_parent){
                continue;
            }

            union(x_parent, y_parent);
            components--;
        }

        if(components == 1){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int root = find(i);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        long finalVal = 0;

        for(int i=1; i<list.size(); i++){
            sum -= list.get(i-1);
            finalVal += (long) sum*list.get(i-1);
        }
        return finalVal;
    }
}