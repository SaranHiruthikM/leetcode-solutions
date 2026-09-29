class Solution {
    HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> res = new ArrayList<>();

    private void dfs(String src) {
        PriorityQueue<String> neighbors = adj.get(src);

        while(neighbors != null && !neighbors.isEmpty()) {
            String next = neighbors.poll();
            dfs(next);
        }

        res.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> ticket : tickets) {
            adj.computeIfAbsent(
                ticket.get(0),
                k -> new PriorityQueue<>()
            ).offer(ticket.get(1));
        }

        dfs("JFK");

        Collections.reverse(res);

        return res;
    }
}