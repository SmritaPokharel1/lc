package trie;

public class Trie {

    Node root;

    public Trie() {

        root = new Node();
    }

    public void insert(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {

                node.children[c - 'a'] = new Node();
            }

            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {

        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {

            char c = prefix.charAt(i);

            if (node.children[c - 'a'] == null) return false;

            node = node.children[c - 'a'];
        }

        return node != null;
    }

    class Node {

        Node[] children;
        boolean isWord;

        public Node(Node[] children, boolean isWord) {

            this.children = children;
            this.isWord = isWord;
        }

        public Node() {

            this.children = new Node[26];
            this.isWord = false;
        }
    }
}