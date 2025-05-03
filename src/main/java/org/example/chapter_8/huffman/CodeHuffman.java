package org.example.chapter_8.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CodeHuffman {

    // Используем HashMap для кодов Хаффмана для гибкости
    private static final Map<Character, String> huffmanCodes = new HashMap<>();
    private static Tree huffmanTree;

    public static void main(String[] args) {
        String source = "SUSIE SAYS IT IS EASY";

        // Шаг 1: Создаем карту частот
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char e : source.toCharArray()) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        // Шаг 2: Строим дерево Хаффмана
        PriorityQueue<Tree> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Node root = new Node(entry.getKey(), entry.getValue());
            priorityQueue.add(new Tree(root));
        }

        // Строим дерево Хаффмана
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll().root();
            Node right = priorityQueue.poll().root();
            Node parent = new Node(null, left.value + right.value);
            parent.leftChild = left;
            parent.rightChild = right;
            priorityQueue.add(new Tree(parent));
        }

        // Получаем корень дерева
        huffmanTree = priorityQueue.poll();

        // Шаг 3: Генерация кодов Хаффмана
        generateHuffmanCodes(huffmanTree.root(), "");

        // Шаг 4: Кодируем сообщение
        String encodedMessage = encodeMessage(source);
        System.out.println("Encoded Message: " + encodedMessage);

        // Шаг 5: Декодируем сообщение
        String decodedMessage = decodeMessage(encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }

    // Метод для генерации кодов Хаффмана
    public static void generateHuffmanCodes(Node node, String code) {
        if (node.leftChild == null && node.rightChild == null && node.key != null) {
            // Записываем код для символа в таблицу
            huffmanCodes.put(node.key, code);
            System.out.println("'" + node.key + "' → " + code);
            return;
        }
        if (node.leftChild != null)
            generateHuffmanCodes(node.leftChild, code + "0");
        if (node.rightChild != null)
            generateHuffmanCodes(node.rightChild, code + "1");
    }

    // Метод для кодирования сообщения
    public static String encodeMessage(String message) {
        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            String code = huffmanCodes.get(c);
            if (code != null) {
                encoded.append(code);
            } else {
                throw new IllegalArgumentException("No Huffman code found for character: " + c);
            }
        }
        return encoded.toString();
    }

    // Метод для декодирования сообщения
    public static String decodeMessage(String encodedMessage) {
        StringBuilder decoded = new StringBuilder();
        Node currentNode = huffmanTree.root();  // начинаем с корня дерева Хаффмана

        for (int i = 0; i < encodedMessage.length(); i++) {
            // Перемещаемся по дереву в зависимости от бита
            if (encodedMessage.charAt(i) == '0') {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }

            // Если достигли листа (символа), добавляем его к декодированному сообщению
            if (currentNode.leftChild == null && currentNode.rightChild == null) {
                decoded.append(currentNode.key);
                currentNode = huffmanTree.root();  // возвращаемся к корню дерева
            }
        }

        return decoded.toString();
    }

}
