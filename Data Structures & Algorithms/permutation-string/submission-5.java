class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Input: s1 = "abc", s2 = "lecabee"
        //lecabee

        Map<Character,Integer> mp1=new HashMap<>();
        Map<Character,Integer> mp2=new HashMap<>();
        
        if(s1.length()>s2.length()){
            return false;
        }

        for(int i=0;i<s1.length();i++){
            mp1.put(s1.charAt(i),mp1.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int i=0;i<s1.length();i++){
            mp2.put(s2.charAt(i),mp2.getOrDefault(s2.charAt(i),0)+1);
        }

        int i=0;
        
        for(int j=s1.length();j<s2.length();j++){
            System.out.println(mp1);
            System.out.println(mp2);
            
            if(match(mp1,mp2))
                return true;
            else{
                mp2.put(s2.charAt(i),mp2.getOrDefault(s2.charAt(i),0)-1);
                if(mp2.get(s2.charAt(i))<=0)
                    mp2.remove(s2.charAt(i));
                i++;
            }
            mp2.put(s2.charAt(j),mp2.getOrDefault(s2.charAt(j),0)+1);
        }
        if(match(mp1,mp2))
            return true;

        return false;
    }
    public boolean match(Map<Character,Integer> mp1,Map<Character,Integer> mp2){
        for(char x: mp1.keySet()){
            if(mp1.get(x)==mp2.get(x)){
                continue;
            }
            else
                return false;
        }
        return true;
    }
}
