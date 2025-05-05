package org.example.chapter_8.huffman;

record Tree(Node root) implements Comparable<Tree> {

    @Override
    public int compareTo(Tree o) {
        return Integer.compare(root.value, o.root.value);
    }

    @Override
    public String toString() {
        return "(" + root.key + ", " + root.value + ")";
    }
}
