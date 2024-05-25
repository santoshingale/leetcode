class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList();
        dfs(0, s, wordDict, new ArrayList(), result);
        return result;
    }

    public void dfs(int idx, String s, List<String> wordDict, List<String> path, List<String> result){

        if(idx >= s.length()){
            StringBuilder sb = new StringBuilder();
            for(String ss : path){
                sb.append(ss);
                sb.append(" ");
            }
            System.out.println(sb);
            result.add(0, sb.toString().substring(0, sb.length() -1));
            return;
        }
        for(int end = idx +1; end <= s.length(); end++){
            String sub = s.substring(idx, end);
            if(wordDict.contains(sub)){
                path.add(sub);
                dfs(end, s, wordDict, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}