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

    void insertLast(long dData) { // Элемент в конец списка
        Link newLink = new Link(dData); // Создание нового элемента
        if (isEmpty()) // Если список не содержит элементов,
            first = newLink; // first --> newLink
        else {
            last.next = newLink; // старое значение last --> newLink
            newLink.previous = last; // старое значение last <-- newLink
        }
        last = newLink; // newLink <-- last
    }

    Link deleteFirst() { // Удаление первого элемента (предполагается, что список не пуст)
        Link temp = first;
        if (first.next == null) // Если только один элемент
            last = null; // null <-- last
        else
            first.next.previous = null; // null <-- старое значение next
        first = first.next; // first --> старое значение next;
        return temp;
    }

    Link deleteLast() { // Удаление последнего элемента (предполагается, что список не пуст)
        Link temp = last;
        if (first.next == null) // Если только один элемент
            first = null; // first --> null
        else
            last.previous.next = null; // старое значение previous --> null
        last = last.previous; // старое значение previous <-- last
        return temp;
    }

    boolean insertAfter(long key, long dData) { // Вставка dData в позицию после key (предполагается, что список не пуст)
        Link current = first; // От начала списка
        while (current.dData != key) { // Пока не будет найдено совпадение
            current = current.next; // Переход к следующему элементу
            if (current == null)
                return false; // Ключ не найден
        }
        Link newLink = new Link(dData); // Создание нового элемента
        if (current == last) { // Для последнего элемента списка
            newLink.next = null; // newLink --> null
            last = newLink; // newLink <-- last
        } else { // Не последний элемент
            newLink.next = current.next; // newLink --> старое значение next
            current.next.previous = newLink; // newLink <-- старое значение next
        }
        newLink.previous = current; // старое значение current <-- newLink
        current.next = newLink; // старое значение current --> newLink
        return true; // Ключ найден, вставка выполнена
    }

    Link deleteKey(long key) { // Удаление элемента с заданным ключом (предполагается, что список не пуст)
        Link current = first; // От начала списка
        while (current.dData != key) { // Пока не будет найдено совпадение
            current = current.next; // Переход к следующему элементу
            if (current == null)
                return null; // Ключ не найден
        }
        if (current == first) // Ключ найден; это первый элемент?
            first = current.next; // first --> старое значение next
        else // Не первый элемент
            current.previous.next = current.next; // старое значение previous --> старое значение next
        if (current == last) // Последний элемент?
            last = current.previous; // старое значение previous <-- last
        else // Не последний элемент
            current.next.previous = current.previous; // Старое значение previous <-- старое значение next
        return current; // Возвращение удаленного элемента
    }

    void displayForward() {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while (current != null) { // Перемещение до конца списка
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println();
    }

    void displayBackward() {
        System.out.print("List (last-->first): ");
        Link current = last; // От начала списка
        while (current != null) { // Перемещение до конца списка
            current.displayLink(); // Вывод данных
            current = current.previous; // Переход к следующему элементу
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
