package org.example.chapter_8.full_java_code;

import java.util.Base64;
import java.util.Stack;

public class Tree {

    private final Node root; // first node of tree

    public Tree() { // Конструктор
        this.root = null; // Пока нет ни одного узла
    }

    public static void main(String[] args) {

    }

    public Node find(int key) {
        Node current = root;

        while (current.dData != key) {

            if (current.dData > key) {
                current = current.leftChild;
            }
            if (current.dData < key) {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }
}
