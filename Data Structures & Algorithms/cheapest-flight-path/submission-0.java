class Solution {

    Map<Integer,List<int[]>> graph;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dfs and do k--;
        // we have to process in order of cheapest flights...
        graph=new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int flight[]:flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.offer(new int[]{src,0,0});
        int prices[]=new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src]=0;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int currNode=curr[0];
            int currPrice=curr[1];
            int dist=curr[2];
            if(currNode==dst && dist<=k+1)
                return currPrice;
            for(int nei[]:graph.get(currNode)){
                int nextNode=nei[0];
                int weight=nei[1];
                prices[nextNode]=currPrice+weight;
                pq.offer(new int[]{nextNode,prices[nextNode],dist+1});
            }
        
        }
        return -1;
    }
}
