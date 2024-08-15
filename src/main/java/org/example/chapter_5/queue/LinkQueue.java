package org.example.chapter_5.queue;

import org.example.chapter_5.doubly_sided_linked_list.FirstLastList;

public class LinkQueue {

    private final FirstLastList theList;

    public LinkQueue() { // Конструктор
        this.theList = new FirstLastList(); // Создание 2-стороннего списка
    }

    public boolean isEmpty() { // true, если очередь пуста
        return theList.isEmpty();
    }

    public void insert(long j) { // Вставка элемента в конец очереди
        theList.insertLast(j);
    }

    public long remove() { // Удаление элемента в начале очереди
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }

    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20); // Вставка элементов
        theQueue.insert(40);

        theQueue.displayQueue(); // Вывод содержимого очереди

        theQueue.insert(60); // Вставка элементов
        theQueue.insert(80);

        theQueue.displayQueue(); // Вывод содержимого очереди

        theQueue.remove(); // Удаление элементов
        theQueue.remove();

        theQueue.displayQueue(); // Вывод содержимого очереди
    }
}
