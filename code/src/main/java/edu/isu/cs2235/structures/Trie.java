package edu.isu.cs2235.structures;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(false);
    }

    public void addWord(String word) {
        TrieNode currentNode = root;
        for(int i = 0; i < word.length(); i++) {
            TrieNode nextNode = currentNode.getChildFromChar(word.toCharArray()[i]);
            if(nextNode == null) {
                currentNode.addChild(word.toCharArray()[i], new TrieNode(false));
                nextNode = currentNode.getChildFromChar(word.toCharArray()[i]);
            }

            // If we're on the last character, set the isEndOfWord flag on the final node
            if(i == word.length() - 1) {
                nextNode.setIsEndOfWord(true);
            }
            currentNode = nextNode;
        }
    }

    public boolean contains(String word) {
        TrieNode currentNode = root;
        for(char character : word.toCharArray()) {
            currentNode = currentNode.getChildFromChar(character);
            if(currentNode == null) {
                return false;
            }
        }
        return currentNode.getIsEndOfWord();
    }
}
