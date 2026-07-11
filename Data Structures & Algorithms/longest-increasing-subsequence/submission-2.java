class Solution {
    int dp[];
    public int lengthOfLIS(int[] nums) {
        // lis dfs(i,nums) // lis starting at i
        int n=nums.length;
        int ans=0;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dfs(i,nums));
        }
        return ans;

    }

    public int dfs(int idx,int[] nums){
        int n=nums.length;
        if(idx>=n)
            return 0;
        
        if(dp[idx]!=-1)
            return dp[idx];

        int ans=1;
        for(int j=idx+1;j<n;j++){
            if(nums[j]>nums[idx]){
                ans=Math.max(ans,1+dfs(j,nums));
            }
        }
        return dp[idx]=ans;
    }

}
