package org.example.chapter_8.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    /**
     * Построение дерева Хаффмана
     */
    public static HuffmanNode buildTree(String source) {

        // Шаг 1: Создаем карту частот
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char e : source.toCharArray()) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        // Шаг 2: Строим дерево Хаффмана
        PriorityQueue<HuffmanTree> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            HuffmanNode root = new HuffmanNode(entry.getKey(), entry.getValue());
            priorityQueue.offer(new HuffmanTree(root));
        }

        // Строим дерево Хаффмана
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll().root();
            HuffmanNode right = priorityQueue.poll().root();
            HuffmanNode parent = new HuffmanNode(null, left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            priorityQueue.offer(new HuffmanTree(parent));
        }

        // Получаем корень дерева
        return priorityQueue.poll().root();
    }

    /**
     * Генерация кода Хаффмана
     */
    public static Map<Character, String> generateCodes(HuffmanNode root) {
        Map<Character, String> codes = new HashMap<>();
        generateCodesHelper(root, "", codes);
        return codes;
    }

    private static void generateCodesHelper(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root != null) {
            if (root.left == null && root.right == null && root.key != null) {
                // Записываем код для символа в таблицу
                huffmanCodes.put(root.key, code);
                System.out.println("'" + root.key + "' → " + code);
            } else {
                generateCodesHelper(root.left, code + "0", huffmanCodes);
                generateCodesHelper(root.right, code + "1", huffmanCodes);
            }
        }
    }

    /**
     * Кодирование текста
     */
    public static String encode(String text, Map<Character, String> huffmanCodes) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encoded.append(huffmanCodes.get(ch));
        }
        return encoded.toString();
    }

    /**
     * Декодирование закодированной строки
     */
    public static String decode(String encodedText, HuffmanNode root) {
        StringBuilder decoded = new StringBuilder();
        HuffmanNode currentNode = root;  // начинаем с корня дерева Хаффмана

        for (char bit : encodedText.toCharArray()) {
            // Перемещаемся по дереву в зависимости от бита
            if (bit == '0') {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }

            // Если достигли листа (символа), добавляем его к декодированному сообщению
            if (currentNode.left == null && currentNode.right == null) {
                decoded.append(currentNode.key);
                currentNode = root;  // возвращаемся к корню дерева
            }
        }
        return decoded.toString();
    }

}
