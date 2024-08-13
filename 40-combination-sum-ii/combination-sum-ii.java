class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = new HashMap();
        List<List<Integer>> result = new ArrayList();
        List<Integer> combination = new ArrayList();
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, combination);
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer>combination){
        if(target > 0){
            for(int i = index; i < candidates.length && target >= candidates[i]; i++){
                if(i > index && candidates[i] == candidates[i -1])
                    continue;
                combination.add(candidates[i]);
                helper(candidates, target - candidates[i], i + 1, result, combination);
                combination.remove(combination.size() - 1);
            }
        }
        else if(target == 0){
            result.add(new ArrayList(combination));
        }
    }
}