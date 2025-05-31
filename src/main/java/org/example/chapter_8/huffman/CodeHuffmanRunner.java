package org.example.chapter_8.huffman;

import java.util.Map;

public class CodeHuffmanRunner {

    public static void main(String[] args) {
        String text = "SUSIE SAYS IT IS EASY";
        HuffmanNode huffmanNode = HuffmanCoding.buildTree(text);
        Map<Character, String> huffmanCodes = HuffmanCoding.generateCodes(huffmanNode);
        // Кодирование и декодирование
        String encoded = HuffmanCoding.encode(text, huffmanCodes);
        String decoded = HuffmanCoding.decode(encoded, huffmanNode);

        System.out.println("\nЗакодированная строка:");
        System.out.println(encoded);

        System.out.println("\nДекодированная строка:");
        System.out.println(decoded);
    }

}
