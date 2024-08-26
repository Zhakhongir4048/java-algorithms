package org.example.chapter_5.doubly_linked_list;

class DoublyLinkedList {

    private Link first; // Ссылка на первый элемент списка
    private Link last; // Ссылка на последний элемент списка

    boolean isEmpty() { // true, если список пуст
        return first == null;
    }

    void insertFirst(long dData) { // Вставка элемента в начало списка
        Link newLink = new Link(dData); // Создание нового элемента
        if (isEmpty()) // Если список не содержит элементов,
            last = newLink; // newLink <-- last
        else
            first.previous = newLink; // newLink <-- старое значение first
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }
}
