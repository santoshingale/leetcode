class WordDictionary {

    // This is not an easy problem.

    class TrieNode {
        TrieNode [] next = new TrieNode[26];
        boolean isTerminal = false;        
    }

    TrieNode root; // global store? For? 

    public WordDictionary() {
        root = new TrieNode();  // for lazy intialisation, and not eager initialisation        
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode(); // this TrieNode won't know it's next children
            }
            curr = curr.next[c - 'a']; // pointer shifting, to the node on line no. 18
        }
        curr.isTerminal = true;
    }
    
    public boolean search(String word) {
        return wildCardSearch(0, word, root);  
    }

    private boolean wildCardSearch(int idx, String word, TrieNode curr) {
        if(idx >= word.length()) {
            return curr.isTerminal;
        }

        if(root == null) {
            return false;
        }

        if(word.charAt(idx) == '.') {
            for(int i = 0; i < 26; i++) {
                if(curr.next[i] != null) {
                    if(wildCardSearch(idx + 1, word, curr.next[i]))
                        return true;
                }
            }
            return false;
        }
        else {
            if(curr.next[word.charAt(idx) - 'a'] != null) {
                return wildCardSearch(idx + 1, word, curr.next[word.charAt(idx) - 'a']);
            }
            else {
                return false;
            }
        }
    }
}