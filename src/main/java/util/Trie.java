package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2016/4/12.
 */
class TrieNode {
    // Initialize your data structure here.
    private String val;
    public TrieNode() {
        this.val = "";
    }
    public TrieNode(String val) {
        this.val = val;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");