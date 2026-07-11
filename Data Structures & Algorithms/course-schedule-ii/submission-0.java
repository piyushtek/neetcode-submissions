class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            mp.get(pre[i][1]).add(pre[i][0]);
        }
        int visited[]=new int[numCourses];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(mp,i,visited,st))
                return new int[0];
        }
        int ans[]=new int[numCourses];
        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }

    public boolean dfs(Map<Integer,List<Integer>> mp,int x,int visited[],Stack<Integer> st){

        if(visited[x]==1)
            return false;
        if(visited[x]==2)
            return true;

        visited[x]=1;
        for(int i:mp.get(x)){
            if(!dfs(mp,i,visited,st)){
                return false;
            }
        }
        st.push(x);
        visited[x]=2;
        return true;
    }

}
