package org.example.chapter_2.binary_search;

public class OrderedApp {

    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        OrdArray arr; // Ссылка на массив
        arr = new OrdArray(maxSize); // Создание массива

        arr.insert(99); // Вставка 10 элементов
        arr.insert(77);
        arr.insert(55);
        arr.insert(44);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55; // Поиск элемента
        if (arr.find(searchKey) != -1)
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display(); // Вывод содержимого

        arr.delete(0); // Удаление трех элементов
        arr.delete(55);
        arr.delete(99);

        arr.display(); // Повторный вывод
    }

}
