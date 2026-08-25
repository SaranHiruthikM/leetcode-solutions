class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        boolean vis[] = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                if(curr == arr.length-1){
                    return steps;
                }
                if(curr-1 >= 0 && !vis[curr-1]) {
                    vis[curr-1] = true;
                    q.offer(curr-1);
                }

                if(curr+1 < arr.length && !vis[curr+1]){
                    vis[curr+1] = true;
                    q.offer(curr+1);
                }

                List<Integer> same = map.get(arr[curr]);
                if(same != null){
                    for(int next : same){
                        if(!vis[next]){
                            vis[next] = true;
                            q.offer(next);
                        }
                    }

                    same.clear();
                }
            }
            steps++;
        }
        return -1;
    }
}