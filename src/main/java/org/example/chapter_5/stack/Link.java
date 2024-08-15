package org.example.chapter_5.stack;

public class Link {

    public long dData; // Данные
    public Link next; // Следующий элемент в списке

    public Link(long dd) { // Конструктор
        this.dData = dd;
    }

    public void displayLink() { // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
}
