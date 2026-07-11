class Solution {
    public int minEatingSpeed(int[] a, int h) {
        //min possible k => 1
        //max possible k => 4

        int min=1;
        int max=Integer.MIN_VALUE;

        int n= a.length;

        for(int i=0;i<n;i++){
            if(max<a[i]){
                max=a[i];
            }
            if(min>a[i]){
                min=a[i];
            }
        }

        return solve(min,max,h,a);
    }

    public int solve(int s ,int e,int h,int a[]){
        int mid=0;
        int min=Integer.MAX_VALUE;
        while(s<=e){
            mid=(s+e)/2;
            if(canDo(a,h,mid)){
                if(mid<min)
                    min=mid;
                e = mid-1;
            }else{
                s=mid+1;
            }
        }
        return min;
    }

    public boolean canDo(int a[],int h,int k){
        int n=a.length;
        int count =0;
        for(int i=0;i<n;i++){
            if(k>a[i])
                count++;
            else{
                if(a[i]%k==0)
                    count = count+ a[i]/k;
                else
                    count=count+a[i]/k+1;
            }
        }
        if(count<=h)
            return true;
        return false;
    }


}
