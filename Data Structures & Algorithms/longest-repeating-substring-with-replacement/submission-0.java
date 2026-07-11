class Solution {
    public int characterReplacement(String s, int k) {

        // s= XYYX k=2
        // XYYX x=>2 y=>2

        // s = "AAABABB", k = 1
        // AAABABB
        // AAABAB maxfreq=4
        // for every window keep the counter of charcter with highest frequency..
        // if windowsize-highestfreq==> remaining charchters<=k
        // its possible to find longest substring..
    

        int n=s.length();
        int i=0,j=0;
        int ans=0;
        Map<Character,Integer> mp=new HashMap<>();
        int maxFreq=0;
        for(j=0;j<n;j++){
            char c= s.charAt(j);
            mp.put(c,mp.getOrDefault(c,0)+1);
            if(mp.get(c)>maxFreq)
                maxFreq=mp.get(c);

            int windowSize=j-i+1;

            while(windowSize-maxFreq>k){ // windowSize (dec) maxFreq(dec)>k  5 - 3 = 2
                mp.put(s.charAt(i),mp.get(s.charAt(i))-1); // adjust maxfreq
                i++;
                windowSize=j-i+1;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}
