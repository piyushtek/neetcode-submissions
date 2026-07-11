class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK");
        return res.reversed();
    }

    private void dfs(String airport) {
        PriorityQueue<String> pq = graph.get(airport);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll(); // consume this ticket
            dfs(next);
        }

        res.add(airport);
    }
}