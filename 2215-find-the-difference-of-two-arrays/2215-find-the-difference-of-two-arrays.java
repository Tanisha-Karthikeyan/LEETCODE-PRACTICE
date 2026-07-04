class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = convertArrayToSet(nums1);
        Set<Integer> set2 = convertArrayToSet(nums2);
        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        for(int value : set1)
        {
            if(!set2.contains(value))
            {
                unique1.add(value);
            }
        }
        for(int value : set2)
        {
            if(!set1.contains(value))
            {
                unique2.add(value);
            }
        }
        return List.of(unique1,unique2);
    }
    private Set<Integer> convertArrayToSet(int[]nums)
    {
        Set<Integer> set = new HashSet<>();
        for(int value :nums)
        {
            set.add(value);
        }
        return set;
    }
}