class Solution {
    public int dijkstra(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, k});
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int weight = curr[0];
            int node = curr[1];

            for(int time[] : times){
                if(time[0] == node){
                    int newCost = weight + time[2];
                    if(newCost < dist[time[1]]){
                        pq.offer(new int[]{newCost, time[1]});
                        dist[time[1]] = newCost;
                    }
                }
            }

            
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=1; i< dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }

            maxi = Math.max(maxi, dist[i]);
        }

        return maxi;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        return dijkstra(times, n, k);
    }
}