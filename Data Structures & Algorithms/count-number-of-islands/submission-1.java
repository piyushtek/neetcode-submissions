class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    dfs(grid,i,j,m,n,vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(char grid[][],int x,int y,int m,int n,int vis[][]){
        vis[x][y]=1;
        for(int a=-1;a<=1;a++){
            for(int b=-1;b<=1;b++){
                if(Math.abs(b)!=Math.abs(a)){
                    // System.out.println(a+" "+b);
                    if(isValid(grid,x+a,y+b,m,n,vis)){
                        dfs(grid,x+a,y+b,m,n,vis);
                    }
                }
            }
        }
    }

    public boolean isValid(char grid[][],int x,int y,int m,int n,int vis[][]){
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]=='0' || vis[x][y]==1){
            return false;
        }
        return true;
    }


}
