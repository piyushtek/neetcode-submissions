class Solution {

    Map<Integer,List<Integer>> graph;
    int visited[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph=new HashMap<>();
        int n=prerequisites.length;
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        visited=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==2)
                continue;
            if(!dfs(i))
                return false;
        }

        return true;
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
        
    
        visited[node]=2;
        return true;
    }

}
