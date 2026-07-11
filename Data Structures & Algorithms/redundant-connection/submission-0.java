class Solution {
    
    int parent[];
    int size[];

    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length+1];
        size=new int[edges.length+1];

        for(int i=0;i<=edges.length;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<edges.length;i++){
            boolean x= union(edges[i][0],edges[i][1]);
            if(x==false)
                return edges[i];
        }
        return new int[0];


    }

    public int find(int x){
        int rootx=parent[x];
        while(rootx!=parent[rootx]){
            parent[rootx]=parent[parent[rootx]];
            rootx=parent[rootx];
        }
        return rootx;
    }

    public boolean union(int x,int y){
        int rootx=find(x);
        int rooty=find(y);
        
        if(rootx==rooty){
            return false;
        }

        if(size[rootx]>size[rooty]){
            parent[rooty]=rootx;
            size[rooty]=size[rooty]+size[rootx];
        }
        else{
            parent[rootx]=rooty;
            size[rootx]=size[rootx]+size[rooty];
        }
        return true;
    }

}
