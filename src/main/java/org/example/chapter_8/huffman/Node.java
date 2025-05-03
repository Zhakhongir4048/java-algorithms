package org.example.chapter_8.huffman;

public class Node<K, V> {

    public K key; // Данные, используемые в качестве ключа
    public V value; // Другие данные
    public Node<K, V> leftChild; // Левый потомок узла
    public Node<K, V> rightChild; // Правый потомок узла

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void displayNode() { // Вывод узла
        System.out.print('{');
        System.out.print(key);
        System.out.print(", ");
        System.out.print(value);
        System.out.print("} ");
    }

}
