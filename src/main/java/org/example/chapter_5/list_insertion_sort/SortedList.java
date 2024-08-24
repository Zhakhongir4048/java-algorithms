package org.example.chapter_5.list_insertion_sort;

class SortedList {

    private Link first; // Ссылка на первый элемент списка

    SortedList(Link[] linkAr) { // Конструктор (аргумент - массив)
        for (Link e : linkAr) {
            insert(e); // Копирование массива в список
        }
    }

    void insert(Link key) { // Вставка (в порядке сортировки)
        Link previous = null; // От начала списка
        Link current = first;
        while (current != null && key.dData > current.dData) { // До конца списка или если ключ > current
            previous = current;
            current = current.next; // Перейти к следующему элементу
        }
        if (previous == null) // В начале списка
            first = key; // first --> key
        else // Не в начале
            previous.next = key; // Старое значение prev --> key
        key.next = current; //  key --> старое значение current
    }

    Link remove() { // Возвращает и удаляет первую ссылку (assumes non-empty list)
        Link temp = first; // Сохранение ссылки
        first = first.next; // Удаление первого элемента
        return temp; // Метод возвращает ссылку на удаленный элемент
    }

    public static void main(String[] args) {
        int size = 10;
        Link[] linkAr = new Link[size]; // Создание массива

        for (int i = 0; i < size; i++) { // Заполнение массива
            int n = (int) (Math.random() * 99); // Случайные числа
            Link newLink = new Link(n); // Создание элемента
            linkAr[i] = newLink; // Сохранение в массиве
        }

        System.out.println("Unsorted array: "); // Вывод содержимого массива
        for (int i = 0; i < size; i++) {
            System.out.print(linkAr[i].dData + " ");
        }
        System.out.println();

        // Создание нового списка, инициализированного содержимым массива
        SortedList theSortedList = new SortedList(linkAr);
        for (int i = 0; i < size; i++) {
            linkAr[i] = theSortedList.remove(); // links from list to array
        }

        System.out.println("Sorted Array: "); // Вывод содержимого массива
        for (int i = 0; i < size; i++) {
            System.out.print(linkAr[i].dData + " ");
        }
        System.out.println();
    }
}
