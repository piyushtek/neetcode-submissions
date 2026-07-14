class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        //Input: s = "caaat", t = "cat"
        return dfs(s,t,0,0);
    }

    int dfs(String s,String t,int x,int y){
       if(y==t.length())
            return 1;
       if(x==s.length())
            return 0;
       char a=s.charAt(x);
       char b=t.charAt(y);
       if(dp[x][y]!=-1)
            return dp[x][y];
       int ans1=dfs(s,t,x+1,y);
       int ans2=0;
       if(a==b){
            ans2=dfs(s,t,x+1,y+1);
       }
       return dp[x][y]=ans1+ans2;

    }
}
