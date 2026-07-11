class Solution {

    class Node{
        int x;
        int count;
        Node(int x,int count){
            this.x=x;
            this.count=count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Node> pq=new PriorityQueue<>((a,b) -> b.count-a.count);
        for(int i:mp.keySet()){
            pq.add(new Node(i,mp.get(i)));
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll().x;
        }
        return ans;
    }
}
