class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
         int[] a = new int[n];
         for (int i = 0,l=1;i<n;i++)
         {
            a[i] = l;
            l*=nums[i];
         }
         for(int i = n-1,r = 1;i>=0;i--)
         {
            a[i]*=r;
            r*=nums[i];
         }
         return a;
    }
}