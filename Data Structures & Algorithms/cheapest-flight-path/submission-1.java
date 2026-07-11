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

        pq.offer(new int[]{src,0,-1});
        int prices[][]=new int[n][k+1];
        for(int i=0;i<n;i++)
            Arrays.fill(prices[i],Integer.MAX_VALUE);
        prices[src][0]=0;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int currNode=curr[0];
            int currPrice=curr[1];
            int currStop=curr[2];
            if(currNode==dst)
                return currPrice;

            for(int nei[]:graph.get(currNode)){
                int nextNode=nei[0];
                int weight=nei[1];
                int nextStop=currStop+1;
                if(nextStop>k)
                    continue;
                
                if(prices[nextNode][nextStop]>currPrice+weight){
                    prices[nextNode][nextStop]=currPrice+weight;
                    pq.offer(new int[]{nextNode,currPrice+weight,nextStop});
                }
            }
        
        }
        return -1;
    }
}
