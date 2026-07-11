class Solution {
    public int numIslands(char[][] a) {
        int m=a.length;
        int n=a[0].length;
        int visited[][]=new int[m][n];
        int max=0;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && a[i][j]=='1'){
                    solve(a,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void solve(char a[][],int x,int y,int visited[][]){
        if(x>=a.length || x<0 || y>=a[0].length || y<0 || visited[x][y]==1 || a[x][y]=='0')
            return;

        visited[x][y]=1;
        
        solve(a,x+1,y,visited);
        solve(a,x,y+1,visited);
        solve(a,x-1,y,visited);
        solve(a,x,y-1,visited);
        
    }
}
