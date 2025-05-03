package org.example.chapter_8.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CodeHuffman {

    public static void main(String[] args) {
        String source = "SUSIE SAYS IT IS EASY";
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char e : source.toCharArray())
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);

        PriorityQueue<Tree> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Node<Character, Integer> root = new Node<>(entry.getKey(), entry.getValue());
            priorityQueue.add(new Tree(root));
        }

        System.out.println(priorityQueue);

        while (priorityQueue.size() != 1) {
            Tree poll = priorityQueue.poll();
            Tree poll2 = priorityQueue.poll();
            Node<Character, Integer> parent = new Node<>(' ', poll.getRoot().value + poll2.getRoot().value);
            parent.leftChild = poll.getRoot();
            parent.rightChild = poll2.getRoot();
            priorityQueue.add(new Tree(parent));
        }

        Tree huffmanTree = priorityQueue.poll();
        generateHuffmanCodes(huffmanTree.getRoot(), "");

    }

    public static void generateHuffmanCodes(Node<Character, Integer> node, String code) {
        if (node.leftChild == null && node.rightChild == null && node.key != ' ') {
            System.out.println("'" + node.key + "' → " + code);
            return;
        }
        if (node.leftChild != null)
            generateHuffmanCodes(node.leftChild, code + "0");
        if (node.rightChild != null)
            generateHuffmanCodes(node.rightChild, code + "1");
    }

}
