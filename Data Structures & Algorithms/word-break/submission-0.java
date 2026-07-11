class Solution {
    int dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return dfs(s,0,wordDict);
    }

    public boolean dfs(String s,int idx,List<String> wordDict){
        if(idx>=s.length())
            return true;
        
        if(dp[idx]!=-1){
            if(dp[idx]==1)
                return true;
            else
                return false;
        }

        boolean ans=false;

        for(int i=idx;i<s.length();i++){
            String curr=s.substring(idx,i+1);
            if(!wordDict.contains(curr))
                continue;
            ans=dfs(s,i+1,wordDict);
            if(ans){
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }


}
