class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] a) {
        
        int m=a.length;
        int n=a[0].length;
        int vis1[][] =new int[m][n];
        int vis2[][] =new int[m][n];
        for(int i=0;i<m;i++){
            dfs(a,i,0,vis1);
            dfs(a,i,n-1,vis2);
        }
        for(int j=0;j<n;j++){
            dfs(a,0,j,vis1);
            dfs(a,m-1,j,vis2);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis1[i][j]==1 && vis2[i][j]==1){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }   
        return ans;
    }

    public void dfs(int a[][],int x,int y,int[][] vis){
        if(x>=a.length || y>=a[0].length || x<0 || y<0 || vis[x][y]==1){
            return;
        }
        vis[x][y]=1;

        if(x+1< a.length && a[x+1][y]>=a[x][y])
            dfs(a,x+1,y,vis);

        if(y+1< a[0].length && a[x][y+1]>=a[x][y])
            dfs(a,x,y+1,vis);

        if(x-1>=0 &&  a[x-1][y]>=a[x][y])
            dfs(a,x-1,y,vis);

        if(y-1>=0 &&  a[x][y-1]>=a[x][y])
            dfs(a,x,y-1,vis);


    }
}
