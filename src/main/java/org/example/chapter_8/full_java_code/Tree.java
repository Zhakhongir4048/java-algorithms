package org.example.chapter_8.full_java_code;

import java.util.Stack;

public class Tree {

    private Node root; // first node of tree

    public Tree() { // Конструктор
        this.root = null; // Пока нет ни одного узла
    }

    public Node find(int key) { // Поиск узла с заданным ключом (предполагается, что дерево не пустое)
        Node current = root; // Начать с корневого узла
        while (current.iData != key) { // Пока не найдено совпадение
            if (key < current.iData) // Двигаться налево?
                current = current.leftChild;
            else // Или направо?
                current = current.rightChild;
            if (current == null) // Если потомка нет,
                return null; // поиск завершился неудачей
        }
        return current; // Элемент найден
    }

    public void insert(int id, double dd) {
        Node newNode = new Node(); // Создание нового узла
        newNode.iData = id; // Вставка данных
        newNode.dData = dd;
        if (root == null) // Корневой узел не существует
            root = newNode;
        else { // Корневой узел занят
            Node current = root; // Начать с корневого узла
            Node parent;
            while (true) { // (внутренний выход из цикла)
                parent = current;
                if (id < current.iData) { // Двигаться налево?
                    current = current.leftChild;
                    if (current == null) { // Если достигнут конец цепочки,
                        parent.leftChild = newNode; // вставить слева
                        return;
                    }
                } else { // Или направо?
                    current = current.rightChild;
                    if (current == null) { // Если достигнут конец цепочки,
                        parent.rightChild = newNode; // вставить справа
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) { // Удаление узла с заданным ключом (предполагается, что дерево не пусто)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) { // Поиск узла
            parent = current;
            if (key < current.iData) { // Двигаться налево?
                isLeftChild = true;
                current = current.leftChild;
            } else { // Или направо?
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) { // Конец цепочки
                return false; // Узел не найден
            }
        }

        // Удаляемый узел найден

        // Если узел не имеет потомков, он просто удаляется.
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) { // Если узел является корневым,
                root = null; // дерево очищается
            } else if (isLeftChild) {
                parent.leftChild = null; // Узел отсоединяется от родителя
            } else {
                parent.rightChild = null;
            }
        }
        // Если нет правого потомка, узел заменяется левым поддеревом
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        // Если нет левого потомка, узел заменяется правым поддеревом
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        // Два потомка, узел заменяется преемником
        else {
            // Поиск преемника для удаляемого узла (current)
            Node successor = getSuccessor(current);

            // Родитель current связывается с посредником
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }
        // Преемник связывается с левым потомком current
        return true; // Признак успешного завершения
    }

    // Метод возвращает узел со следующим значением после delNode.
    // Для этого он сначала переходит к правому потомку, а затем отслеживает цепочку левых потомков этого узла.
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // Переход к правому потомку
        while (current != null) { // Пока остаются левые потомки
            successorParent = successor;
            successor = current;
            current = current.leftChild; // Переход к левому потомку
        }
        if (successor != delNode.rightChild) { // Если преемник не является правым потомком
            successorParent.leftChild = successor.rightChild; // создать связи между узлами
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        // todo
    }
}
