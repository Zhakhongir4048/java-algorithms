package org.example.chapter_8.huffman;


public class Tree implements Comparable<Tree> {

    private final Node<Character, Integer> root;

    public Tree(Node<Character, Integer> root) {
        this.root = root;
    }

    public Node<Character, Integer> getRoot() {
        return root;
    }

    @Override
    public int compareTo(Tree o) {
        return root.value.compareTo(o.root.value);
    }

    @Override
    public String toString() {
        return root.key + " " + root.value;
    }
}
