package org.example.chapter_5.iterator;

class Link {

    long dData; // Данные
    Link next; // Следующий элемент в списке

    Link(long dData) { // Конструктор
        this.dData = dData;
    }

    void displayLink() { // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
}
