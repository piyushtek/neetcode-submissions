class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int curr=0;
        int max=0;

        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=0;
        
        for(int i=0;i<n;i++){
            left[i]=max;
            if(height[i]>max){
                max=height[i];
            }
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            right[i]=max;
            if(height[i]>max){
                max=height[i];
            }
        }

        for(int i=0;i<n;i++){
            if(Math.min(left[i],right[i])-height[i]>0)
                curr=curr+ (Math.min(left[i],right[i])-height[i]);
        }
        return curr;
    }
}
