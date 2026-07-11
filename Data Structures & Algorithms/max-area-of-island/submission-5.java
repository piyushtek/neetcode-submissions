class Solution {
    
    int parent[];
    int rank[];
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        parent=new int[m*n];
        rank=new int[m*n];
        for(int i=0;i<m*n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int a=0;a<=1;a++){
                        for(int b=0;b<=1;b++){
                            if(i+a<m && j+b<n && grid[i+a][j+b]==1 && Math.abs(a)!=Math.abs(b)){
                                //i*n+j
                                union(i*n+j,(i+a)*n+j+b);
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<m*n;i++){
            System.out.print(parent[i]+" ");
        }
        System.out.println(" ");

        for(int i=0;i<m*n;i++){
            System.out.print(rank[i]+" ");
        }
        
        int max = 0;
        for (int i = 0; i < m * n; i++) {
            if (grid[i / n][i % n] == 1 && parent[i] == find(i)) {
                max = Math.max(max, rank[i]);
            }
        }

        return max;
    }

    int find(int x){
        if(parent[x]!=x)
            parent[x]=find(parent[x]);
        return parent[x];
    }

    void union(int x,int y){
        int p1=find(x);
        int p2=find(y);
        if (p1 == p2) return;
        if(rank[p2]>=rank[p1]){
            parent[p1]=p2;
            rank[p2]=rank[p2]+rank[p1];
        }
        else{
            parent[p2]=p1;
            rank[p1]=rank[p1]+rank[p2];
        }
        
    }


}
