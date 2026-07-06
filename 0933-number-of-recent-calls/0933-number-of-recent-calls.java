class RecentCounter {
    private int[] time = new int[10010];
    private int cur;
    public RecentCounter() {
        cur=0;
    }
    
    public int ping(int t) {
        time[cur++]=t;
        int first = binarySearch(t-3000);
        return cur - first;
    }
    private int binarySearch(int target)
    {
        int left = 0;
        int right = cur;
        while(left<right)
        {
            int mid = left+(right-left)/2;
            if(time[mid]>=target)
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */