class Solution {
    int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }

    int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
    
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        int max=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            int temp=max(nums[i],nums[i]*min,nums[i]*max);
            min=min(nums[i],nums[i]*min,nums[i]*max);
            max=temp;
            ans=Math.max(max,ans);                        
        }
        return ans;
    }
}
