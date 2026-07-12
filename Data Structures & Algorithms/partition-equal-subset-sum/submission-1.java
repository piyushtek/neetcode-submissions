class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        // sum=target/2'
        int sum=0;
        
        for(int num:nums){
            sum=sum+num;
        }
        if(sum%2!=0)
            return false;
        int target=sum/2;
        dp=new Boolean[nums.length+1][target+1];
        

        return dfs(target,nums,0);
    }

    boolean dfs(int target,int[] nums,int idx){
        if(target==0)
            return true;
        if(idx>=nums.length)
            return false;
        if(target<0)
            return false;

        if(dp[idx][target]!=null)
            return dp[idx][target];

        boolean ans1=dfs(target,nums,idx+1);
        boolean ans2=dfs(target-nums[idx],nums,idx+1);
        return dp[idx][target]=ans1 || ans2;
    }
}
