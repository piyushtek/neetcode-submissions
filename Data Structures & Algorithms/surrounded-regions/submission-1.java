class Solution {
    public void solve(char[][] a) {
        int m=a.length;
        int n=a[0].length;
        int vis[][]=new int[m][n];

        for(int i=0;i<m;i++){
            if(a[i][0]=='O')
                dfs(a,i,0,vis);
            if(a[i][n-1]=='O')
                dfs(a,i,n-1,vis);
        }
        for(int j=0;j<n;j++){
            if(a[0][j]=='O')
                dfs(a,0,j,vis);
            if(a[m-1][j]=='O')
                dfs(a,m-1,j,vis);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }

    }
    
    public void dfs(char a[][],int x,int y,int vis[][]){
        if(x>=a.length || y>=a[0].length || x<0 || y<0 || vis[x][y]==1 || a[x][y]=='X')
            return;

        vis[x][y]=1;
        dfs(a,x+1,y,vis);
        dfs(a,x,y+1,vis);
        dfs(a,x-1,y,vis);
        dfs(a,x,y-1,vis);

    }
}
