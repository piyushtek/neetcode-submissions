class Solution {
    public int[] twoSum(int[] a, int target) {
        

        //[1,2,3,4] ==> target =3
        // i=0 j=1

        int i=0;
        int j=a.length-1;

        while(i<j){
            int s=a[i]+a[j];
            while(i<j && s<target){
                i++;
                s=a[i]+a[j];
            }
            if(s==target)
                return new int[]{i+1,j+1};
            j--;
        }
        return null;

    }
}
