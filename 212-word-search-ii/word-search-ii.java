class Solution {
    int[] moves = {-1, 0, 1, 0, -1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList();
        TrieNode root = buildTrieNode(words);
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                dfs(row, col, root, board, result);
            }
        }
        return result;
    }

    private void dfs(int row, int col, TrieNode root, char[][] board, List<String> result){
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0){
            return;
        }
        char c = board[row][col];
        if(c == '#' || root.next[c - 'a'] == null){
            return;
        }
        TrieNode curNode = root.next[c - 'a'];
        if(curNode.word != null){
            result.add(curNode.word);
            curNode.word = null;
        }
        board[row][col] = '#';
        for(int i = 0; i < moves.length - 1; i++){
            dfs(row + moves[i], col + moves[i + 1], curNode, board, result);
        }
        board[row][col] = c;
    }

    private TrieNode buildTrieNode(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                int curIdx = c - 'a';
                if(cur.next[curIdx] == null){
                    cur.next[curIdx] = new TrieNode();
                }
                cur = cur.next[curIdx];
            }
            cur.word = word;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}