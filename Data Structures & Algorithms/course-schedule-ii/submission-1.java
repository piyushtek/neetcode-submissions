class Solution {
    Map<Integer,List<Integer>> graph;
    List<Integer> ans;
    int visited[];
    public int[] findOrder(int numCourses, int[][] pre) {
        int n=pre.length;
        graph=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            graph.get(pre[i][0]).add(pre[i][1]);
        }    
        visited=new int[numCourses];
        ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++){

            if(!dfs(i))
                return new int[0];
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(int node){
        if(visited[node]==1)
            return false;
        
        if(visited[node]==2)
            return true;

        visited[node]=1;

        for(int nei:graph.get(node)){
            if(!dfs(nei))
                return false;
        }
        ans.add(node);
        visited[node]=2;
        return true;

    }
}
