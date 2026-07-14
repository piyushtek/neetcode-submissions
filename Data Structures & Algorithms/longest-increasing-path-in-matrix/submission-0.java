class Solution {
    int m,n;
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        // length of longest increasing path
        m=matrix.length;
        n=matrix[0].length;
        dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dfs(matrix,i,j));
            }
        }
        return 1+ans;
    }

    int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
    int dfs(int[][] matrix,int x,int y){

        int ans=0;
        if(dp[x][y]!=-1)
            return dp[x][y];
        for(int dir[]:dirs){
            int nx=x+dir[0];
            int ny=y+dir[1];
            if(nx<0 || ny<0 || nx>=m || ny>=n || matrix[nx][ny]<=matrix[x][y])
                continue;
            ans=Math.max(ans,1+dfs(matrix,nx,ny));
        }
        return dp[x][y]=ans;
    }
}
