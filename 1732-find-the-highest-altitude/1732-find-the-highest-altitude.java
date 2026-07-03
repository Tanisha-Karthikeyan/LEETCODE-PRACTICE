class Solution {
    public int largestAltitude(int[] gain) {
        int a = 0;
        int max = 0;
        for(int g:gain)
        {
            a+=g;
            max = Math.max(max,a);
        }
        return max;
    }
}