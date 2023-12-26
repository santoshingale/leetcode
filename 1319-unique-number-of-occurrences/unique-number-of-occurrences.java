class Solution {
    Map<Integer, Integer> count = new HashMap();
    public boolean uniqueOccurrences(int[] arr) {
        for(int num : arr){
             count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet();
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(set.contains(entry.getValue())){
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }
}