class Solution {
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,grid[0][0]});
        int m=grid.length;
        int n=grid[0].length;

        // for(int i=0;i<m;i++){
        //     A
        // }

        int vis[][]=new int[m][n];
        vis[0][0]=1;
        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int x=curr[0];
            int y=curr[1];
            int t=curr[2];
            if(x==m-1 && y==n-1)    
                return t;
            for(int dir[]:dirs){
                int nx=x+dir[0];
                int ny=y+dir[1];
                if(nx<0 || ny<0 || nx>=m || ny>=n || vis[nx][ny]==1){
                    continue;
                }
                vis[nx][ny]=1;
                int newTime=Math.max(t,grid[nx][ny]);
                pq.offer(new int[]{nx,ny,newTime});
            }
        }
        return m*n;
    }
}
