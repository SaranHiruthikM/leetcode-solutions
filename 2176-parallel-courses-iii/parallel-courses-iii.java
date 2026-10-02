class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int indeg[] = new int[n];
        int maxTime[] = new int[n];
        for(int i=0; i<relations.length; i++){
            int u = --relations[i][0];
            int v = --relations[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indeg[v]++;
        }

        for(int i=0; i<n; i++){
            if(indeg[i] == 0){
                q.offer(i);
                maxTime[i] = time[i];
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                for(int v : adj.getOrDefault(curr, new ArrayList<>())){
                    maxTime[v] = Math.max(maxTime[v], time[v] + maxTime[curr]);
                    indeg[v]--;
                    if(indeg[v] == 0) {
                        q.offer(v);
                    }
                }
            }
        }

        int ans = 0;

        for(int t : maxTime)
            ans = Math.max(ans, t);

        return ans;
    }
}