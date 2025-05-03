package org.example.chapter_8.huffman;

public class Node {

    Character key; // Данные, используемые в качестве ключа
    Integer value; // Другие данные
    Node leftChild; // Левый потомок узла
    Node rightChild; // Правый потомок узла

    Node(Character key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
