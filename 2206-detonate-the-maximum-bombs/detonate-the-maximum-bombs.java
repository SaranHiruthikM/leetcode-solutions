class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    int localResult;
    private void dfs(int src, boolean[] vis){
        vis[src] = true;
        localResult++;
        for(int v :adj.getOrDefault(src, new ArrayList<>())){
            if(!vis[v]){
                dfs(v, vis);
            }
        }
    }
        
    
    public int maximumDetonation(int[][] bombs) {
        for(int i=0; i<bombs.length; i++){
            for(int j=0; j<bombs.length; j++){
                if(i == j) continue;

                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int r1 = bombs[i][2];

                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                int r2 = bombs[j][2];

                double d = Math.sqrt( Math.pow((x2-x1), 2) +  Math.pow((y2-y1), 2));

                if(r1 >= d){
                    adj.computeIfAbsent(i,k -> new ArrayList<>()).add(j);
                }
            }
        }


        int result = 0;
        for(int i=0; i<bombs.length; i++){
            localResult = 0;
            dfs(i, new boolean[bombs.length]);
            result = Math.max(result, localResult);
        }

        return result;
    }
}