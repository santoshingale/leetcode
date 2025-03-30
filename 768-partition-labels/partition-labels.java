class Solution {
    public List<Integer> partitionLabels(String s) {
       int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i) - 'a'] = i;
        
        List<Integer> ls = new ArrayList();
        int j = 0;
        int anchor = 0;
        for(int i = 0; i < s.length(); i++){
            j = Math.max(j, lastIndex[s.charAt(i) - 'a']);
            if(i == j){
                ls.add(i + 1 - anchor);
                anchor = i +1;
            }
        }
        return ls;
    }
}