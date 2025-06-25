package org.example;

import org.example.chapter_8.dfs_bfs.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void cycleSort(int[] nums) {
        int n = nums.length;

        for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
            int item = nums[cycleStart];
            int pos = cycleStart;

            // Находим позицию, куда должен пойти текущий элемент
            for (int i = cycleStart + 1; i < n; i++) {
                if (nums[i] < item) {
                    pos++;
                }
            }

            // Если элемент уже на своём месте — пропускаем
            if (pos == cycleStart) continue;

            // Пропускаем дубликаты
            while (item == nums[pos]) {
                pos++;
            }

            // Меняем
            if (pos != cycleStart) {
                int temp = item;
                item = nums[pos];
                nums[pos] = temp;
            }

            // Перемещаем оставшиеся элементы в цикле
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < n; i++) {
                    if (nums[i] < item) {
                        pos++;
                    }
                }

                while (item == nums[pos]) {
                    pos++;
                }

                int temp = item;
                item = nums[pos];
                nums[pos] = temp;
            }
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
            current.left = null;
            if (!stack.isEmpty()) {
                current.right = stack.peek();
            } else {
                current.right = null;
            }
        }

        System.out.println(root);
    }

    /**
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * Morris Traversal (flatten) шаг за шагом:
     * ➤ Шаг 1:
     * current = 1, есть left = 2
     * Ищем предшественника в left-поддереве:
     * → идём от 2 вправо до конца → 4
     * Присоединяем 1.right (то есть 5) к 4.right
     * 1
     * \
     * 2
     * / \
     * 3   4
     * \
     * 5
     * \
     * 6
     * 1.right = 2, 1.left = null
     * Переход к current = 2
     * ➤ Шаг 2:
     * current = 2, есть left = 3
     * Предшественник = 3 (у него right == null)
     * Присоединяем 2.right (это 4) к 3.right
     * 2.right = 3, 2.left = null
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * Переход к current = 3
     * ➤ Шаги 3 → 6:
     * 3.left == null → просто двигаемся вправо
     * 4.left == null
     * 5.left == null
     * 6.left == null
     */
    public static void flattenMorris(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                // Найти предшественника (самый правый в левом поддереве)
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Присоединить правое поддерево к предшественнику
                predecessor.right = current.right;

                // Переместить левое поддерево направо
                current.right = current.left;
                current.left = null;
            }

            // Переходим к следующему узлу
            current = current.right;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {40, 10, 20, 30};
//        cycleSort(nums);
//        System.out.println(Arrays.toString(nums));

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//
//        root.right = new TreeNode(5);
//        root.right.right = new TreeNode(6);
//
//
//        flatten(root);
//        final String s = "SALAM";
//        final String s2 = "SA" + "LAM";
//
//        System.out.println(s == s2);

        Node node = new Node(1, List.of(new Node(3,
                List.of(new Node(5), new Node(6))), new Node(2), new Node(4)));

        levelOrder(node);
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        Deque<List<Node>> deque = new ArrayDeque<>();
        deque.push(root.children);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> one = new LinkedList<>();
        one.add(root.val);
        result.add(one);

        while (!deque.isEmpty() && !deque.peek().isEmpty()) {
            List<Node> current = deque.poll();
            List<Integer> temp = new LinkedList<>();
            List<Node> newNods = new ArrayList<>();
            for (Node el : current) {
                temp.add(el.val);
                if (el.children != null && !el.children.isEmpty()) {
                    newNods.addAll(el.children);
                }
            }
            deque.offer(newNods);
            result.add(temp);

        }
        return result;
    }
}
