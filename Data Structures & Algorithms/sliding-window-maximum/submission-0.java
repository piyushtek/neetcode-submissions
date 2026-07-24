class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // [1,2,1,0,4,2,6] k=3
        // [2,2,4,4,6]
        // [1 1 2            

        int i=0;
        int n=nums.length;
        Deque<Integer> q=new ArrayDeque<>();
        int ans[]=new int[n-k+1];
        for(int j=i;j<n;j++){
            while(!q.isEmpty() && nums[q.peekLast()]<nums[j]){
                q.pollLast();
            }

            q.offerLast(j);
            if(j-i+1==k){
                ans[i]=nums[q.peekFirst()];
                i++;
                if(q.peekFirst()<i)
                    q.pollFirst();
            }
        }
        return ans;


    }
}
