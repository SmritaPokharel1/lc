package trie;

/**
 * Create a data structure that can store words and check if a given string matches any stored word.
 *
 * Implement the WordDictionary class with these operations:
 *
 * WordDictionary() — Creates a new, empty dictionary.
 *
 * void addWord(word) — Stores a new word in the dictionary for future searches.
 *
 * boolean search(word) — Returns true if there exists any stored word matching the input. The input may contain the dot character '.', which can match any single letter.
 *
 * Example:
 *
 * graphql
 * Copy
 * Edit
 * Input:
 * ["WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"]
 * [[], ["cat"], ["car"], ["cart"], ["bat"], ["car"], ["c.t"], ["ca.."]]
 *
 * Output:
 * [null, null, null, null, false, true, true, true]
 * Explanation:
 *
 * pgsql
 * Copy
 * Edit
 * WordDictionary dict = new WordDictionary();
 * dict.addWord("cat");
 * dict.addWord("car");
 * dict.addWord("cart");
 *
 * dict.search("bat");   // false — "bat" not stored
 * dict.search("car");   // true — exact match
 * dict.search("c.t");   // true — '.' matches 'a'
 * dict.search("ca..");  // true — matches "cart"
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 */
public class LC211_DesignAndAddSearchWordsDataStructure {

    Node trie;

    class Node{

        boolean isWord;
        Node[] children;

        public Node(){

            isWord = false;
            children = new Node[26];
        }

        public Node(Node[] children, boolean isWord){

            this.isWord = isWord;
            this.children = children;
        }
    }
    public LC211_DesignAndAddSearchWordsDataStructure() {

        trie = new Node();
    }

    public void addWord(String word) {

        Node node = trie;

        for(int i = 0; i < word.length(); i++){

            char c = word.charAt(i);

            if(node.children[c -'a']==null) node.children[c -'a'] = new Node();

            node = node.children[c -'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = trie;
        return dfs(word,node, 0);
    }

    public boolean dfs(String word, Node node, int index){

        if(index == word.length()){

            return node != null && node.isWord;
        }

        char c = word.charAt(index);

        if(c =='.'){

            for(Node child : node.children){
                if(child!=null && dfs(word, child, index +1)){
                    return true;
                }
            }

            return false;

        }else{

            Node child = node.children[c - 'a'];
            return child!= null && dfs(word, child,index +1);
        }
    }
}
