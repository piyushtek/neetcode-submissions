class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            mp.put(i,new ArrayList<>());
        }    
        for(int i=0;i<pre.length;i++){
            mp.get(pre[i][1]).add(pre[i][0]);
        }
        int visited[] =new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!dfs(mp,i,visited))
                return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer,List<Integer>> mp,int x,int visited[]){

        if(visited[x]==1)
            return false;
        
        if(visited[x]==2)
            return true;

        visited[x]=1;
        for(int i:mp.get(x)){
            boolean flag= dfs(mp,i,visited);
            if(!flag)
                return false;
        }
        visited[x]=2;
        return true;
    }

}
