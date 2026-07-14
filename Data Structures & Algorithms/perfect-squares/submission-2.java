class Solution {
    int dp[];
    public int numSquares(int n) {
        List<Integer> squares=new ArrayList<>();
        dp=new int[n+1];
        for(int i=1;i<=n;i++){
            if(i*i<=n)
                squares.add(i*i);
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        return bottomUp(squares,n);
    }


    public int bottomUp(List<Integer> squares,int n){
        dp[0]=0;        
        for(int i=1;i<=n;i++){
            for(int square:squares){
                if(i<square)
                    break;
                int temp=dp[i-square];
                if(temp!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],1+temp);
            }    
        }

        return dp[n];
    }


    public int dfs(List<Integer> squares,int n){
        if(n<0)
            return Integer.MAX_VALUE;
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int ans=Integer.MAX_VALUE;

        for(int square:squares){
            if(n<square)
                break;
            int temp=dfs(squares,n-square);
            if(temp!=Integer.MAX_VALUE)
                ans=Math.min(ans,1+temp);
        }
        return dp[n]=ans;
    }
}