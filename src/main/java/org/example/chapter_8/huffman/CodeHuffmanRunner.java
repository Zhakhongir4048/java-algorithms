package org.example.chapter_8.huffman;

public class CodeHuffmanRunner {

    public static void main(String[] args) {
        String text = "SUSIE SAYS IT IS EASY";
        HuffmanTree huffmanTree = HuffmanCoding.buildTree(text);
        HuffmanCoding.generateCodes(huffmanTree.root(), "");
        // Кодирование и декодирование
        String encoded = HuffmanCoding.encode(text);
        String decoded = HuffmanCoding.decode(encoded, huffmanTree.root());

        System.out.println("\nЗакодированная строка:");
        System.out.println(encoded);

        System.out.println("\nДекодированная строка:");
        System.out.println(decoded);
    }

}
