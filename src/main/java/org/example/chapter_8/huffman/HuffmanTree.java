package org.example.chapter_8.huffman;

record HuffmanTree(HuffmanNode root) implements Comparable<HuffmanTree> {

    @Override
    public int compareTo(HuffmanTree o) {
        return Integer.compare(root.freq, o.root.freq);
    }

    @Override
    public String toString() {
        return "(" + root.key + ", " + root.freq + ")";
    }
}
