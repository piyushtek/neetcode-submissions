class Solution {
    public int maxProfit(int[] a) {
        //[10,1,5,6,7,1] ==>

        int n=a.length;
        int i=0;
        int max=0;
        for(int j=1;j<n;j++){
            while(a[j]<a[i]){
                i++;
            }
            if(max<a[j]-a[i])
                max=a[j]-a[i];
        
        }
        return max;
    }
}
