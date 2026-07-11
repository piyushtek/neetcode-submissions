class Solution {
    public int maxAreaOfIsland(int[][] a) {
        int m=a.length;
        int n=a[0].length;
        int ans=0;
        int max=0;
        int visited[][]=new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && a[i][j]==1){
                    ans=solve(a,i,j,visited);
                    if(max<ans)
                        max=ans;
                }
            }
        }
        return max;
    }

    public int solve(int a[][],int x,int y,int visited[][]){
        if(x>=a.length || y>=a[0].length || x<0 || y<0 || visited[x][y]==1 || a[x][y]==0)
            return 0;
        visited[x][y]=1;
        int ans1=solve(a,x+1,y,visited);
        int ans2=solve(a,x-1,y,visited);
        int ans3=solve(a,x,y+1,visited);
        int ans4=solve(a,x,y-1,visited);
        return 1+ans1+ans2+ans3+ans4;
    }
}
