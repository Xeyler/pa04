package edu.isu.cs2235.structures;

import java.util.Set;

public class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode(boolean isEndOfWord) {
        children = new TrieNode[26];
        this.isEndOfWord = isEndOfWord;
    }

    public TrieNode getChildFromChar(char character) {
        character = Character.toLowerCase(character);
        return children[character - 'a']; // subtract 'a' because the value of 'a' to offset the numeric value of characters(See an ascii table for more info)
    }

    public void addChild(char character, TrieNode node) {
        character = Character.toLowerCase(character);
        children[character - 'a'] = node;
    }

    public boolean getIsEndOfWord() {
        return isEndOfWord;
    }

    public void setIsEndOfWord(boolean value) {
       isEndOfWord = value;
    }
}
