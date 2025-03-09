class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet<Character> hs = new HashSet();
        // int l = 0, r = 0;
        // int max = 0;

        // while(r < s.length()){
        //     if(hs.contains(s.charAt(r))){
        //         hs.remove(s.charAt(l));
        //         l++;
        //     }else{
        //         hs.add(s.charAt(r));
        //         max = Math.max(max, hs.size());
        //         r++;
        //     }
        // }
        // return max;


        Map<Character, Integer> visited = new HashMap();
        int n = s.length();
        int right = 0;
        int left = 0;
        int maxLen = 0;
        while(right < n){
            if(visited.containsKey(s.charAt(right))){
                left = Math.max(left , visited.get(s.charAt(right)) + 1);
            }
            visited.put(s.charAt(right), right);
            maxLen = Math.max( maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}