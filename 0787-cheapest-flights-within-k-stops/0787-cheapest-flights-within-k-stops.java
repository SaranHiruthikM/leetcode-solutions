class Solution {
    public int dijkstra(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, src, 0});

        int[][] dist = new int[n][k+2];
        for(int i=0; i<dist.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int sorc = curr[1];
            int stops = curr[2];

            if(sorc == dst){
                return cost;
            }

            for(int[] flight : flights){
                if(flight[0] == sorc){
                    if(stops + 1 > k+1){
                        continue;
                    }

                    int minCost = dist[flight[1]][stops+1];
                    int currCost = cost + flight[2];

                    if(minCost > currCost) {
                        pq.add(new int[]{currCost, flight[1], stops+1});
                        dist[flight[1]][stops+1] = currCost;
                    }
                    
                }
            }
        }

        return -1;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return dijkstra(n, flights, src, dst, k);
    }
}