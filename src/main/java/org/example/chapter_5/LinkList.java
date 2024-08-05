package org.example.chapter_5;

public class LinkList {

    private Link first; // Ссылка на первый элемент списка

    public boolean isEmpty() { // true, если список пуст
        return first == null;
    }

    public void insertFirst(int iD, double dD) { // Создание нового элемента
        Link newLink = new Link(iD, dD);
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    public Link deleteFirst() { // Удаление первого элемента (предполагается, что список не пуст)
        Link temp = first; // Сохранение ссылки
        first = first.next; // Удаление: first --> ссылка на второй элемент
        return temp; // Метод возвращает ссылку на удаленный элемент
    }
}
