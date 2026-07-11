class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        Map<String,List<String>> mp=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String x=strs[i];
            char a[]=x.toCharArray();
            Arrays.sort(a);
            String y=new String(a);
            if(mp.containsKey(y)){
                mp.get(y).add(x);
            }
            else{
                List<String> ls=new ArrayList<>();
                ls.add(x);
                mp.put(y,ls);
            }
        }

        for(String key: mp.keySet()){
            ans.add(mp.get(key));
        }
        return ans;

    }
}
