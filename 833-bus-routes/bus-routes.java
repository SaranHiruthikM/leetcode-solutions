class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                int u = routes[i][j];
                int v = i;
                adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        for(int v : adj.getOrDefault(source, new ArrayList<>())){
            q.offer(v);
            vis.add(v);
        }

        int buses = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll(); 
                for(int i=0; i<routes[curr].length; i++){
                    if(routes[curr][i] == target) return buses;
                    for(int nextRoute : adj.getOrDefault(routes[curr][i], new ArrayList<>())){
                        if(!vis.contains(nextRoute)){
                            q.add(nextRoute);
                            vis.add(nextRoute);
                        }
                    }
                }

            }
            buses++;
        }

        return -1;
    }
}