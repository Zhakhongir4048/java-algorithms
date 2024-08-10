package org.example.chapter_5.doubly_sided_linked_list;

public class Link {

    public long dData; // Данные
    public Link next; // Следующий элемент в списке

    public Link(long d) { // Конструктор
        this.dData = d;
    }

    public void displayLink() { // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
}
