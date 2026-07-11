class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1  1  2  8
        // 48 24 6  1

        int pre[]=new int[nums.length];
        int suff[]=new int[nums.length];
        // int ans[]=new int[nums.length];

        pre[0]=1;
        
        suff[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }

        for(int i=nums.length-2;i>=0;i--){
            suff[i]=suff[i+1]*nums[i+1];
        }

        for(int i=0;i<nums.length;i++){
            pre[i]=pre[i]*suff[i];
        }
        return pre;

        

    }
}  
