class Solution {
    int dp[];
    public int numDecodings(String s) {
        // observations:
        // discard string starting with 0
        // every index can be converted to letter
        // and check one more letter forward of it if its eligible
        // eligbilitty should be not starting with 0
        dp=new int[s.length()+1];
        // Arrays.fill(dp,-1);
        int n=s.length();
        dp[n]=1;
        int nextTwo = 1; // dp[n]
        int nextOne = s.charAt(n - 1) == '0' ? 0 : 1; // dp[n-1]
        //dp[1]=1
        // dp[0]
        for(int i=n-2;i>=0;i--){
            int temp=0;
            int curr=s.charAt(i)-'0';
            if(curr!=0){
                
                temp=nextOne;
                if(i+1<n){
                    int next=s.charAt(i+1)-'0';

                    if (curr == 1 || (curr == 2 && next <= 6)) {
                        temp=temp+nextTwo;
                    }
                }
                
            }
            nextTwo=nextOne;
            nextOne=temp;
        }   
        return nextOne;
        // return dfs(s,0);
    }

    public int dfs(String s,int idx){
        if(idx==s.length())
            return 1;
        if(idx>s.length())
            return 0;
        int curr= s.charAt(idx)-'0';
        int next=-1;
        if(dp[idx]!=-1)
            return dp[idx];
        if(idx+1<s.length())
            next=s.charAt(idx+1)-'0';

        int ans1=0,ans2=0;
        if(curr!=0){
            ans1=dfs(s,idx+1);
            if (curr == 1 || (curr == 2 && next <= 6)) {
                ans2 = dfs(s, idx + 2);
            }        
        }
        return dp[idx]=ans1+ans2;
    }

    // 12           1            12
    // dfs(0)--> 1+ dfs(1) + 1+ dfs(2)
}
