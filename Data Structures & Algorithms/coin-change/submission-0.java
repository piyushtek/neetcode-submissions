class Solution {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        Arrays.fill(dp,-1);

        int ans=dfs(coins,amount);
        if(ans==Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }

    public int dfs(int [] coins,int amount){
        if(amount==0)
            return 0;
        if(amount<0)
            return Integer.MAX_VALUE;
        if(dp[amount]!=-1)
            return dp[amount];
        int ans=Integer.MAX_VALUE;
        for(int coin:coins){
            int curr = dfs(coins,amount-coin);
            if(curr!=Integer.MAX_VALUE)
                ans=Math.min(ans,1+curr);
        }
        return dp[amount]=ans;
    }
}
