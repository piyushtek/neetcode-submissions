class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int i=0;
        Map<Character,Integer> mp = new HashMap<>();
        int ans=0;
        int max=0;
        if(n==1 || n==0)
            return n;
        for(int j=0;j<n;j++){

            char c = s.charAt(j);
            if(!mp.containsKey(c)){
                mp.put(c,j);
                if(j-i+1>max)
                    max=j-i+1;
            }
            else{
                while(mp.containsKey(c) && i<=j){
                    mp.remove(s.charAt(i));
                    i++;
                }
                mp.put(c,j);
            }

        }
        return max;
    }
}
