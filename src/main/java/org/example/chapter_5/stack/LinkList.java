package org.example.chapter_5.stack;

public class LinkList {

    private Link first; // Ссылка на первый элемент в списке

    public boolean isEmpty() { // true, если список пуст
        return first == null;
    }

    public void insertFirst(long dd) { // Вставка элемента в начало списка
        Link newLink = new Link(dd); // Создание нового элемента
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    public long deleteFirst() { // Удаление первого элемента (предполагается, что список не пуст)
        Link temp = first; // Сохранение ссылки
        first = first.next; // Удаление: first-->ссылка на второй элемент
        return temp.dData; // Метод возвращает данные удаленного элемента
    }

    public void displayList() {
        Link current = first; // От начала списка
        while (current != null) { // Перемещение до конца списка
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println();
    }
}
