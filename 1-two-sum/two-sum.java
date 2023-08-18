class Solution {
    public int[] twoSum(int[] nums, int target) {
        int remaining = 0; 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            remaining = target - nums[i];
            if(hm.containsKey(remaining)){
                ans[0] = hm.get(remaining);
                ans[1] = i;
                return ans;
            }
            hm.put(nums[i],i);
        }
        return ans;
    }
}