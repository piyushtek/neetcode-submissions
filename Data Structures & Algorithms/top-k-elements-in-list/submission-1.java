class Solution {

    class Node{
        int n;
        int cnt;
        Node(int x,int y){
            n=x;
            cnt=y;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int ans[]=new int[k];
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->b.cnt-a.cnt);
        for(int key:mp.keySet()){
            pq.offer(new Node(key,mp.get(key)));
        }
        int i=0;
        while(k>0){
            ans[i]=pq.poll().n;
            i++;
            k--;
        }
        return ans;

    }
}
