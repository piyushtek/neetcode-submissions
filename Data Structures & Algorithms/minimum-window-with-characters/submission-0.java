class Solution {
    public String minWindow(String s, String t) {
        // minimum window substring
        // such that all characters of t are in s
        // i=0 j=0;
        // initialize countt[] with character count in t;
        // keep a variable that keep tracks of matches.
        //  initialize counts[] with character count in s;

        Map<Character,Integer> countt =new HashMap<>();
        
        Map<Character,Integer> counts =new HashMap<>();

        for(int i=0;i<t.length();i++){
            countt.put(t.charAt(i),countt.getOrDefault(t.charAt(i),0)+1);
        }

        int matches=0; // notifying number of characters where count are same for t and s

        
        int i=0;
        int j=0;
        int ans=Integer.MAX_VALUE;
        String sub="";
        for(j=0;j<s.length();j++){
            char x=s.charAt(j);
            counts.put(x,counts.getOrDefault(x,0)+1);
            
            if(countt.containsKey(x) && counts.get(x)<=countt.get(x)){
                matches++;
            }
            
            while(matches==t.length()){
                
                if(j-i+1<ans){
                    ans=j-i+1;
                    sub=s.substring(i,j+1);
                }
                counts.put(s.charAt(i),counts.get(s.charAt(i))-1);
                if(countt.containsKey(s.charAt(i)) && counts.get(s.charAt(i))<countt.get(s.charAt(i))){
                    matches--;
                }
                i++;
            }
        }
        return sub;
    }
}
