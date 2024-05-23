class Solution {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        helper(0, new ArrayList(), nums, k);
        return count;
    }

    public void helper(int index, List<Integer> path, int[] nums, int k){
        if(index >= nums.length ){
            if(path.size() > 0) count++;
            return;
        }
        if(!path.contains(nums[index] - k)){
            path.add(nums[index]);
            helper(index + 1, path, nums, k);
            path.remove(path.size() - 1);
        }
        helper(index + 1, path, nums, k);
    }

}