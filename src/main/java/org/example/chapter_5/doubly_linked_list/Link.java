package org.example.chapter_5.doubly_linked_list;

class Link {

    long dData; // Данные
    Link next; // Следующий элемент в списке
    Link previous; // Предыдущий элемент в списке

    Link(long dData) { // Конструктор
        this.dData = dData;
    }

    void displayLink() { // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
}
