class Solution {
    public void moveZeroes(int[] nums) {
        int begining = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[begining] = nums[i];
                begining++;
            }
        }
        while(begining<nums.length)
        {
            nums[begining++]=0;
        }
    }
}