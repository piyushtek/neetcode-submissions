class Solution {
    int dp[];
    public int combinationSum4(int[] nums, int target) {
        dp=new int[target+1];
        Arrays.fill(dp,-1);
        return dfs(nums,target);
    }

    int dfs(int[] nums,int target){
        if(target<0)
            return 0;
        
        if(target==0)
            return 1;
        
        if(dp[target]!=-1)
            return dp[target];

        int ans=0;
        for(int num:nums){
            ans=ans+dfs(nums,target-num);
        }
        return dp[target]=ans;
    }
}