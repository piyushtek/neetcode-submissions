class Solution {
    public int countSubstrings(String s) {
        //"aaa"
        // palindrome
        // odd length palindrome
        // even length palindrome
        int count=0;
        for(int i=0;i<s.length();i++){
            count=count+check(i,i+1,s);// even case
            count=count+check(i,i,s); //odd case
        }
        return count;
    }

    public int check(int left,int right,String s){
        int n=s.length();
        int count=0;
        while(left>=0 && right<n){
            if(s.charAt(left)==s.charAt(right))
                count++;
            else
                break;
            left--;
            right++;
        }
        return count;
    }



}
