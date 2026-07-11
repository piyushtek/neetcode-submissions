class Solution {
    int dp[][];
    public int minimizeMax(int[] nums, int p) {
        // minimize the maximum sum.
        // p pairs
        // take ith number and jth number
        // consider them as one pair
        // get one ith number, find a jth number with with absolute difference is lowest
        // [10,1,2,7,1,3] ==> 10,7 1,1==> 3
        // [1,1,2,3,7,10]
        // if we pick i,i+1 as pair then next answere is f(i+2,p-1)
        // if we dont pick ith index then next answere is f(i+1,p);
        dp=new int[nums.length+1][p+1];
        for(int i=0;i<nums.length+1;i++)
        {
            for(int j=0;j<=p;j++){
                dp[i][j]=-1;
            }
        }
        Arrays.sort(nums);
        return solve(nums,0,p);
        
    }

    int solve(int nums[],int x,int p){
        
        if(p<=0)
            return dp[x][p]=0;

        if(x+1>=nums.length)
            return dp[x][p]=Integer.MAX_VALUE;

        if(dp[x][p]!=-1)
            return dp[x][p];

        int curr=nums[x+1]-nums[x];
        int rest=solve(nums,x+2,p-1);
        int ans1=Math.max(curr,rest);

        int ans2=solve(nums,x+1,p);
        return dp[x][p]=Math.min(ans1,ans2);
    
    }

}