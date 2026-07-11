class Solution {
    
    int parent[];
    int size[];

    public int countComponents(int n, int[][] edges) {
        parent=new int[n];
        size=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<edges.length;i++){
            union(edges[i][0],edges[i][1]);
        }
        Set<Integer> s=new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++){
            System.out.print(parent[i]);
        }
        for(int i=0;i<n;i++){
            int root=find(i);
            if (!s.contains(root)) {
                s.add(root);
                count++;
            }
        }
        return count;
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]]; // path compression
            x = parent[x];
        }
        return x;
    }

    public void union(int x,int y){
        int rootx=find(x);
        int rooty=find(y);
        
        if(rootx==rooty)
            return;

        if(size[rootx]>size[rooty]){
            parent[rooty]=rootx;
            size[rootx]=size[rooty]+size[rootx];
        }
        else{
            parent[rootx]=rooty;
            size[rooty]=size[rooty]+size[rootx];
        }
    }




}
