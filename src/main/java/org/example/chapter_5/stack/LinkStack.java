package org.example.chapter_5.stack;

public class LinkStack {

    private final LinkList theList;

    public LinkStack() { // Конструктор
        this.theList = new LinkList();
    }

    public void push(long j) { // Размещение элемента на вершине стека
        theList.insertFirst(j);
    }

    public long pop() { // Извлечение элемента с вершины стека
        return theList.deleteFirst();
    }

    public boolean isEmpty() { // true, если стек пуст
        return theList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }

    public static void main(String[] args) {
        LinkStack theStack = new LinkStack(); // Создание стека
        theStack.push(20); // Вставка элементов
        theStack.push(40);

        theStack.displayStack(); // Вывод содержимого стека

        theStack.push(60); // Вставка элементов
        theStack.push(80);

        theStack.displayStack(); // Вывод содержимого стека

        theStack.pop(); // Извлечение элементов
        theStack.pop();

        theStack.displayStack(); // Вывод содержимого стека
    }
}
