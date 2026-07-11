class Solution {
    Boolean dp[][];
    public boolean isSubsequence(String s, String t) {
        
        // node neetcode ==> 
        // i    j

        //
        dp=new Boolean [s.length()+1][t.length()+1];

        return solve(s,t,0,0);
    }   

    public boolean solve(String s,String t,int i,int j){
        
        System.out.println(i+" "+j);
        if(i>=s.length())
            return dp[i][j]=true;
        
        if(j>=t.length())
            return dp[i][j]=false;

        if(dp[i][j]!=null)
            return dp[i][j];

        if(s.charAt(i)==t.charAt(j))
            return dp[i][j]=solve(s,t,i+1,j+1);
        else{
            boolean ans2=solve(s,t,i,j+1);
            if(ans2)
                return dp[i][j]=true;
        }
        return dp[i][j]=false;
    }
}