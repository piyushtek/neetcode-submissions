class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int visited[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    queue.offer(new int[]{i,j,0});
            }
        }
        int dirs[][]={{-1,0},{0,1},{0,-1},{1,0}};
        int count=0;
        while(!queue.isEmpty()){
            List<int[]> currLayer=new ArrayList<>();
            while(!queue.isEmpty()){
                int curr[]=queue.poll();
                currLayer.add(curr);
            }
            count++;
            for(int curr[]:currLayer){
                for(int dir[]:dirs){
                        int nx=curr[0]+dir[0];
                        int ny=curr[1]+dir[1];
                        if(nx<0 || ny<0 || ny>=n || nx>=m || visited[nx][ny]==1 || grid[nx][ny]!=1)
                            continue;
                        grid[nx][ny]=2;
                        visited[nx][ny]=1;
                        queue.offer(new int[]{nx,ny});
                    }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }

        return count==0 ? 0:count-1;
    }
}
