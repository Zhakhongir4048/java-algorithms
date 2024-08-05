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

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while (current != null) {  // Перемещение до конца списка
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99); // Вставка четырех элементов
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList(); // Вывод содержимого списка
        while (!theList.isEmpty()) { // Пока остаются элементы,
            Link deleteFirst = theList.deleteFirst(); // Удаление элемента
            System.out.print("Deleted "); // Вывод удаленного элемента
            deleteFirst.displayLink();
            System.out.println();
        }
        theList.displayList(); // Вывод содержимого списка
    }
}
