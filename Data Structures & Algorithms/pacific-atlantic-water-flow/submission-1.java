class Solution {
    int pvisited[][];
    int avisited[][];
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // r=0 || c=0 pacific
        // r==m-1 || c==n-1 atlantic
        int m=heights.length;
        int n=heights[0].length;

        pvisited=new int[m][n];
        avisited=new int[m][n];

        for(int col=0;col<n;col++){
            dfs(0,col,true,heights); // pacific
            dfs(m-1,col,false,heights); // atlantic
        }
        for(int row=0;row<m;row++){
            dfs(row,0,true,heights); // pacific
            dfs(row,n-1,false,heights); // atlantic
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){   
            for(int j=0;j<n;j++){
                if(avisited[i][j]==1 && pvisited[i][j]==1){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
                    
            }
        }
        return ans;
    }
    int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(int x,int y,boolean isPacific,int [][] heights){
        
        int m=heights.length;
        int n=heights[0].length;

        if(isPacific)
            pvisited[x][y]=1;
        else
            avisited[x][y]=1;

        for(int []dir:dirs){
            int nx=x+dir[0];
            int ny=y+dir[1];

            if(nx<0 || ny<0 || nx>=m || ny>=n || heights[nx][ny]<heights[x][y])
                continue;

            if(isPacific && pvisited[nx][ny]==1){
                continue;
            }
            if(!isPacific && avisited[nx][ny]==1){
                continue;
            }
            dfs(nx,ny,isPacific,heights);
        }
    
    
    }



}
