package org.example.chapter_5.iterator;


class LinkList {

    private Link first; // Ссылка на первый элемент в списке

    Link getFirst() { // Получение первого элемента
        return first;
    }

    void setFirst(Link first) { // Присваивание нового значения first
        this.first = first;
    }

    boolean isEmpty() { // true, если список пуст
        return first == null;
    }

    ListIterator getIterator() { // Получение итератора
        return new ListIterator(this); // Инициализация списком this
    }

    void displayList() {
        Link current = first; // От начала списка
        while (current != null) { // Перемещение до конца списка
            current.displayLink(); // Вывод текущего элемента
            current = current.next; // Переход к следующему элементу
        }
        System.out.println();
    }
}
