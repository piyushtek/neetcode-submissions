class Solution {
    public int countComponents(int n, int[][] edges) {
        // number of connected components
        UnionFind uf=new UnionFind(n);
        int ans=n;
        for(int edge[]:edges){
            boolean temp=uf.union(edge[0],edge[1]);
            if(temp)
                ans--;
        }

        Set<Integer> parents=new HashSet<>();
        for(int x:uf.parent){
            parents.add(x);
        }
        return ans;
    }


    // union find by rank

    class UnionFind{

        int parent[];
        int rank[];

        UnionFind(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            Arrays.fill(rank,1);
        }

        boolean union(int u,int v){
            int rootU=find(u);
            int rootV=find(v);
            
            if(rootU==rootV)
                return false;;

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;

        }

        int find(int x){
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }


    }



}
