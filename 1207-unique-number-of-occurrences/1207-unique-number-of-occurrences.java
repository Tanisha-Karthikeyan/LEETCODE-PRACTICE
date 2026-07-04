class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int ele:arr)
        {
            frequency.merge(ele,1,Integer::sum);
        } 
        return new HashSet<>(frequency.values()).size()==frequency.size();
    }
}