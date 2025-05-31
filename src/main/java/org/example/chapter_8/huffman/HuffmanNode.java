package org.example.chapter_8.huffman;

public class HuffmanNode {

    Character key; // Символ, используется в качестве ключа
    Integer freq; // Частота/количество появления
    HuffmanNode left; // Левый потомок узла
    HuffmanNode right; // Правый потомок узла

    HuffmanNode(Character key, Integer freq) {
        this.key = key;
        this.freq = freq;
    }
}
