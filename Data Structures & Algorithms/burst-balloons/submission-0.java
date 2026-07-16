class Solution {
    int dp[][];
    public int maxCoins(int[] nums) {
        // [[4,2,3,7]]
        // nums = [4,2,3,7] --> [4,3,7] --> [4,7] --> [7] --> []
        // nums[i - 1] * nums[i] * nums[i + 1]
        // 1    [4, 2,  3,  7]  1
        // prev i  after

        int n=nums.length;
        int []a =new int[n+2];
        dp=new int[n+3][n+3];
        for(int i=0;i<n+3;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            a[i+1]=nums[i];
        }
        a[0]=1;
        a[n+1]=1;
        return solve(a,0,n+1);
    }

    int solve(int a[],int left,int right){
        if(left+1==right)
            return 0;

        if(dp[left][right]!=-1)
            return dp[left][right];

        int ans=0;
        for(int k=left+1;k<right;k++){
            int ans1=solve(a,left,k);
            int ans2=solve(a,k,right);
            ans=Math.max(ans,ans1+ans2+a[left]*a[right]*a[k]);
        }
        return dp[left][right]=ans;
    }




}
