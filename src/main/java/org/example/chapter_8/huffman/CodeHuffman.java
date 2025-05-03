package org.example.chapter_8.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CodeHuffman {

    // Массив кодов Хаффмана для каждого символа
    private static final String[] huffmanCodes = new String[28];

    public static void main(String[] args) {
        String source = "SUSIE SAYS IT IS EASY";

        // Шаг 1: Создаем карту частот
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char e : source.toCharArray())
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);

        // Шаг 2: Строим дерево Хаффмана
        PriorityQueue<Tree> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Node root = new Node(entry.getKey(), entry.getValue());
            priorityQueue.add(new Tree(root));
        }

        while (priorityQueue.size() != 1) {
            Node left = priorityQueue.poll().root();
            Node right = priorityQueue.poll().root();
            Node parent = new Node(null, left.value + right.value);
            parent.leftChild = left;
            parent.rightChild = right;
            priorityQueue.add(new Tree(parent));
        }

        // Получаем корень дерева
        Tree huffmanTree = priorityQueue.poll();

        // Шаг 3: Генерация кодов Хаффмана
        generateHuffmanCodes(huffmanTree.root(), "");

        // Шаг 4: Кодируем сообщение
        String encodedMessage = encodeMessage(source);
        System.out.println("Encoded Message: " + encodedMessage);
    }

    // Метод для генерации кодов Хаффмана
    public static void generateHuffmanCodes(Node node, String code) {
        if (node.leftChild == null && node.rightChild == null && node.key != null) {
            // Записываем код для символа в таблицу
            int index = getSymbolIndex(node.key);
            huffmanCodes[index] = code;
            System.out.println("'" + node.key + "' → " + code);
            return;
        }
        if (node.leftChild != null)
            generateHuffmanCodes(node.leftChild, code + "0");
        if (node.rightChild != null)
            generateHuffmanCodes(node.rightChild, code + "1");
    }

    // Получение индекса символа в таблице (A=0, B=1, ..., Пробел=26, новая строка=27)
    public static int getSymbolIndex(char c) {
        if (c == ' ') return 26;
        if (c == '\n') return 27;
        return c - 'A';
    }

    // Метод для кодирования сообщения
    public static String encodeMessage(String message) {
        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            int index = getSymbolIndex(c);
            encoded.append(huffmanCodes[index]);
        }
        return encoded.toString();
    }
}
