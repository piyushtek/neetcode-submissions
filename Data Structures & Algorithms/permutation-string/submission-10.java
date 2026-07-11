class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int count[]=new int[26];

        if(s1.length()>s2.length())
            return false;

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']=count[s1.charAt(i)-'a']+1;
            count[s2.charAt(i)-'a']=count[s2.charAt(i)-'a']-1;
        }
        int matches=26;
        for(int i=0;i<26;i++){
            if(count[i]!=0)
                matches--;
        }
        
        int i=0;
        int j=s1.length()-1;
        while(j<s2.length()){
            if(matches==26)
                return true;
            else{
                count[s2.charAt(i)-'a']++;
                if(count[s2.charAt(i)-'a']==0)
                    matches++;
                else if(count[s2.charAt(i)-'a']==1){
                    matches--;
                }    
                i++;
                j++;
                if(j<s2.length()){
                    count[s2.charAt(j)-'a']--;
                    if(count[s2.charAt(j)-'a']==0)
                        matches++;
                    else if (count[s2.charAt(j)-'a']==-1){
                        matches--;
                    }
                    
                }
            }       
        }
        return matches==26;
    }
}
