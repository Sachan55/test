class Trie {

    class  Node {
        private char value;
        private boolean isEndOfWord;
        private Node [] children;

        Node(char value){
            this.value  = value;
            this.isEndOfWord = false;
            this.children = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c-'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEndOfWord == true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.children[c - 'a'] == null){
               return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}