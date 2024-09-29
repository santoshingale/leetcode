class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        helper(nums, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> result){
        if(temp.size() == nums.length){
            result.add(new ArrayList(temp));
            return;
        }
        for(int i = 0; i <= temp.size(); i++){
            temp.add(i, nums[temp.size()]);
            helper(nums, temp, result);
            temp.remove(i);
        }
    }
}