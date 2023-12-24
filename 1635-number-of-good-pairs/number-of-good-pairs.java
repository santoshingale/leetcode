class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap();
        int ans = 0;
        for(int num : nums){
            ans += countMap.getOrDefault(num, 0);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}