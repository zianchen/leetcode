public class WordDictionary {

    class TrieNode {
        private TrieNode[] children;
        private String item;
        
        public TrieNode() {
            children = new TrieNode[26];
            item = "";
        }
    }
    
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            } 
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(0, word.toCharArray(), root);
    }
    
    public boolean match(int k, char[] ch, TrieNode node) {
        if (k == ch.length) {
            return !node.item.equals("");
        }
        if (ch[k] != '.') {
            return node.children[ch[k] - 'a'] != null && match(k+1, ch, node.children[ch[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if(match(k+1, ch, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");