class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        //[[1,2,4,8],[10,11,12,13],[14,20,30,40]]
        //1,1==> mid=5;
        int m=a.length;
        int n=a[0].length;

        boolean x= solve(a,target,0,m*n-1);
        return x;
    }

    boolean solve(int a[][],int target,int s,int e){
        int m=a.length;
        int n=a[0].length;

        while(s<=e){
            int mid=(s+e)/2;
            int x=mid/n;
            int y=mid%n;
            if(a[x][y]==target)
                return true;
            if(a[x][y]>target)
                e=mid-1;
            else
                s=mid+1;
        }
        return false;

    }
}
