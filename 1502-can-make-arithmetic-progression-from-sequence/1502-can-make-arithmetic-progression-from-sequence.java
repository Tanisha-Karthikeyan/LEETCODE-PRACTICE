class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1]-arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=arr[0]+(i*d))
            {
                return false;
            }
        }
        return true;
    }
}