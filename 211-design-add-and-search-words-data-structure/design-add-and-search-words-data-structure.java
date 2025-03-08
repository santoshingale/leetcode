class WordDictionary {

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isTerminal = false;
    }

    public TrieNode head = null;


    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode root = head;
        for(char c: word.toCharArray()){
            int charIndex = c - 'a';
            if(root.next[charIndex] == null) root.next[charIndex] = new TrieNode();
            root = root.next[charIndex];
        }
        root.isTerminal = true;
    }

    public boolean search(String word) {
        return checkWord(word, 0, head);
    }

    private boolean checkWord(String word, int idx, TrieNode root){
        if(idx >= word.length()) return root.isTerminal;
        if(root == null) return false;
        char c = word.charAt(idx);
        if(c == '.'){
            boolean b = false;
            for(int i = 0; i < 26; i++){
                if(root.next[i] != null){
                    b = b || checkWord(word, idx + 1, root.next[i]);
                }
            }
            return b;
        }else{
            if(root.next[c - 'a'] != null) return checkWord(word, idx + 1, root.next[c - 'a']);
            else return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */