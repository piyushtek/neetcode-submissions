class Solution {
    public int lengthOfLongestSubstring(String s) {
         Map<Character,Integer> mp=new HashMap<>();
         int n=s.length();
         //zxyzxyz

         /// .....i.....j....
         int i=0,j=0;
         int max=0;
         for(j=0;j<n;j++){
            char c=s.charAt(j);
            if(!mp.containsKey(c)){
                mp.put(c,j);
            }
            else{
                System.out.println(mp);
                int curr = j-i;
                
                if(curr>max)
                    max=curr;

                while(i<mp.get(c)){
                    mp.remove(s.charAt(i));
                    i++;
                }
                i++;
                mp.put(c,j);
            }
        }
        if(j-i>max)
            max=j-i; 

        return max;

    }
}
