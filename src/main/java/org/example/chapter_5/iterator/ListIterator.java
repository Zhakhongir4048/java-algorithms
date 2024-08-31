package org.example.chapter_5.iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListIterator {

    private Link current; // Текущий элемент списка
    private Link previous; // Предыдущий элемент списка
    private LinkList ourList; // Связанный список

    ListIterator(LinkList list) { // Конструктор
        this.ourList = list;
        reset();
    }

    void reset() { // Возврат к 'first'
        current = ourList.getFirst();
        previous = null;
    }

    boolean atEnd() { // true, если текущим является
        return (current.next == null); // последний элемент
    }

    void nextLink() { // Переход к следующему элементу
        previous = current;
        current = current.next;
    }

    Link getCurrent() { // Получение текущего элемента
        return current;
    }

    void insertAfter(long dData) { // Вставка после текущего элемента
        Link newLink = new Link(dData);
        if (ourList.isEmpty()) { // Пустой список
            ourList.setFirst(newLink);
            current = newLink;
        } else { // Список не пуст
            newLink.next = current.next;
            current.next = newLink;
            nextLink(); // Переход к новому элементу
        }
    }

    void insertBefore(long dData) { // Вставка перед текущим элементом
        Link newLink = new Link(dData);
        if (previous == null) { // В начале списка (или пустой список)
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else { // Не в начале списка
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    long deleteCurrent() { // Удаление текущего элемента
        long value = current.dData;
        if (previous == null) { // Если в начале списка
            ourList.setFirst(current.next);
            reset();
        } else { // Не в начале списка
            previous.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        // Следующий фрагмент удаляет из списка все элементы с ключами, кратными 3.
        LinkList list = new LinkList(); // Создание списка
        ListIterator iter = list.getIterator(); // Создание итератора

        iter.insertAfter(21); // Вставка элементов
        iter.insertAfter(40);
        iter.insertAfter(30);
        iter.insertAfter(7);
        iter.insertAfter(45);

        list.displayList(); // Вывод содержимого списка

        iter.reset(); // От начала списка
        Link link = iter.getCurrent(); // Получение текущего элемента
        if (link.dData % 3 == 0) // Если ключ кратен 3
            iter.deleteCurrent(); // Элемент удаляется. Следует проверять наличие элементов в списке.

        while (!iter.atEnd()) { // Перемещение до конца списка
            iter.nextLink(); // Переход к следующему элементу
            link = iter.getCurrent(); // Получение текущего элемента
            if (link.dData % 3 == 0) // Если ключ кратен 3
                iter.deleteCurrent(); // Элемент удаляется. Следует проверять наличие элементов в списке.
        }

        list.displayList(); // Вывод содержимого списка
        System.out.println("--------------------------------------");

        LinkList theList = new LinkList(); // Создание списка
        ListIterator iter1 = theList.getIterator(); // Создание итератора
        long value;

        iter1.insertAfter(20); // Вставка элементов
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);

        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar(); // Ввод команды
            switch (choice) {
                case 's' -> { // Вывод списка
                    if (!theList.isEmpty())
                        theList.displayList();
                    else
                        System.out.println("List is empty");
                }
                case 'r' -> iter1.reset(); // Возврат к первому элементу
                case 'n' -> { // Переход к следующему элементу
                    if (!theList.isEmpty() && !iter1.atEnd()) {
                        iter1.nextLink();
                    } else {
                        System.out.println("Can’t go to next link");
                    }
                }
                case 'g' -> { // Получение текущего элемента
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned " + value);
                    } else
                        System.out.println("List is empty");
                }
                case 'b' -> { // Вставка перед текущим элементом
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                }
                case 'a' -> { // Вставка после текущего элемента
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                }
                case 'd' -> { // Удаление текущего элемента
                    if (!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Can’t delete");
                    }
                }
                default -> System.out.println("Invalid entry");
            }
        }
    }

    static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    static char getChar() throws IOException {
        return getString().charAt(0);
    }

    static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
