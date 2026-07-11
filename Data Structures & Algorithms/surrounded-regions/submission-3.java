class Solution {
    
    public void solve(char[][] board) {
        // 

        int m=board.length;
        int n=board[0].length;
        int visited[][]=new int[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && visited[i][0]==0)
                dfs(i,0,board,visited);
            
            if(board[i][n-1]=='O' && visited[i][n-1]==0)
                dfs(i,n-1,board,visited);
            
        }

        for(int i=0;i<n;i++){

            if(board[0][i]=='O' && visited[0][i]==0)
                dfs(0,i,board,visited);
            
            if(board[m-1][i]=='O' && visited[m-1][i]==0)
                dfs(m-1,i,board,visited);

        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }

    int dirs[][]= {{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(int x,int y,char [][] board,int [][]visited){
        
        int m=board.length;
        int n=board[0].length;
        visited[x][y]=1;
        board[x][y]='O';

        for(int dir[]:dirs){
            int nx=x+dir[0];
            int ny=y+dir[1];

            if(nx<0 || ny<0 || nx>=m || ny>=n || visited[nx][ny]==1 || board[nx][ny]=='X'){
                continue;
            }
            
            dfs(nx,ny,board,visited);

        }



    }

}
