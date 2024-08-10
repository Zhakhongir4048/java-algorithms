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

    public Link find(int key) { // Поиск элемента с заданным ключом (предполагается, что список не пуст)
        Link current = first; // Начиная с 'first'
        while (current.iData != key) { // Пока совпадение не найдено
            if (current.next == null) // Если достигнут конец списка
                return null; // и совпадение не найдено
            else // Если еще остались элементы
                current = current.next; // Перейти к следующему элементу
        }
        return current; // Совпадение обнаружено
    }

    public Link delete(int key) { // Удаление элемента с заданным ключом (предполагается, что список не пуст)
        Link current = first; // Поиск элемента
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null)
                return null; // Элемент не найден
            else {
                previous = current; // Переход к следующему элементу, 51 и 52 строка относится к этому
                current = current.next;
            }
        }
        // Совпадение найдено. Тут вся логика по удалению ключа!
        if (current == first) // Если первый элемент
            first = first.next; // Изменить first
        else // В противном случае
            previous.next = current.next; // обойти его в списке
        return current;
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

        System.out.println("------------------------------------");

        // Ниже будут рассмотрены использование методов find и delete
        LinkList linkList = new LinkList(); // Создание нового списка
        linkList.insertFirst(22, 2.99); // Вставка 4 элементов
        linkList.insertFirst(44, 4.99);
        linkList.insertFirst(66, 6.99);
        linkList.insertFirst(88, 8.99);

        linkList.displayList(); // Вывод содержимого списка

        Link found = linkList.find(44); // Поиск элемента
        if (found != null)
            System.out.println("Found link with key " + found.iData);
        else
            System.out.println("Can’t find link");

        Link removed = linkList.delete(66); // Удаление элемента
        if (removed != null)
            System.out.println("Deleted link with key " + removed.iData);
        else
            System.out.println("Can’t delete link");

        linkList.displayList(); // Вывод содержимого списка
    }
}
