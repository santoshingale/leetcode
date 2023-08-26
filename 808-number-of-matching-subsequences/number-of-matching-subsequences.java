class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        Map<Character, Queue<String>> map = new HashMap<>();
        
        for(char c : s.toCharArray())
            map.putIfAbsent(c, new LinkedList());
        
        for(String word: words)
            if(map.containsKey(word.charAt(0)))
                map.get(word.charAt(0)).add(word);
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Queue<String> q = map.get(c);
            int size = q.size();
            
            for(int j = 0; j < size; j++){
                String front = q.poll();
                if(front.length() == 1){
                    ans++;
                }else{
                    if(map.containsKey(front.charAt(1)))
                        map.get(front.charAt(1)).add(front.substring(1));
                }
            }
        }
        return ans;
    }
}