class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i=0; i<rooms.get(curr).size(); i++){
                if(!vis[rooms.get(curr).get(i)]){
                    q.add(rooms.get(curr).get(i));
                    vis[rooms.get(curr).get(i)] = true;
                }
            }
        }

        return IntStream.range(0, vis.length).allMatch(i -> vis[i]);

    }
}