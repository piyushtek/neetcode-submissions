class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Input: s1 = "abc", s2 = "lecabee"
        // i=0 j=s1.size()-1.  0 , 2
        // put everything in window
        // make two map compare 2nd map with 1st map
        // if not equal slide the window

        Map<Character,Integer> mp1=new HashMap<>();
        Map<Character,Integer> mp2=new HashMap<>();
        if(s1.length()>s2.length())
            return false;
        for(int i=0;i<s1.length();i++){
            mp1.put(s1.charAt(i),mp1.getOrDefault(s1.charAt(i),0)+1);
            mp2.put(s2.charAt(i),mp2.getOrDefault(s2.charAt(i),0)+1);
        }

        int i=0;
        int j=s1.length()-1;
        
        while(j<s2.length()){
            boolean x= compare(mp1,mp2);
            if(x)
                return true;
            else{
                mp2.put(s2.charAt(i),mp2.getOrDefault(s2.charAt(i),0)-1);
                if(mp2.get(s2.charAt(i))<=0)
                    mp2.remove(s2.charAt(i));
                i++;
                j++;
                if(j<s2.length())
                    mp2.put(s2.charAt(j),mp2.getOrDefault(s2.charAt(j),0)+1);
            }
        }
        return false;
    }

    boolean compare(Map<Character,Integer> mp1,Map<Character,Integer> mp2){
        for(char x: mp1.keySet()){
            if(!mp2.containsKey(x) || mp1.get(x)!=mp2.get(x))
                return false;
        }
        for(char x: mp2.keySet()){
            if(!mp1.containsKey(x) || mp2.get(x)!=mp1.get(x))
                return false;
        }
        return true;
    }
}
