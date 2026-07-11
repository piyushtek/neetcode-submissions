class Solution {
    Map<Integer,List<Integer>> graph;
    Map<Integer,Set<Integer>> preCompute;
    int visited[];
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) {
        graph=new HashMap<>();
        preCompute=new HashMap<>();
        visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
            preCompute.put(i,new HashSet<>());
        }

        for(int i=0;i<pre.length;i++){
            graph.get(pre[i][0]).add(pre[i][1]);
        }

        for(int i=0;i<numCourses;i++)
            dfs(i);

        List<Boolean> ans=new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            ans.add(preCompute.get(queries[i][0]).contains(queries[i][1]));
        }
        return ans;


    }

    public Set<Integer> dfs(int node){
        
        if(visited[node]==1)
            return preCompute.get(node);
        
        visited[node]=1;    

        for(int nei:graph.get(node)){
            preCompute.get(node).add(nei);
            Set<Integer> childs=dfs(nei);
            preCompute.get(node).addAll(childs);
        }

        return preCompute.get(node);

    }

}