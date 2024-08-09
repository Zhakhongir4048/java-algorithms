package org.example.chapter_2;

public class HighArray {

    private long[] arr; // Ссылка на массив arr
    private int nElems; // Количество элементов в массиве

    public HighArray(int max) { // Конструктор
        arr = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public boolean find(long searchKey) { // Поиск заданного значения
        int j;
        for (j = 0; j < nElems; j++) { // Для каждого элемента
            if (arr[j] == searchKey) // Значение найдено?
                break; // Да - выход из цикла
        }
        return j == searchKey; // Достигнут последний элемент?
    }

    public void insert(long value) { // Вставка элемента в массив
        arr[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) { // Поиск заданного значения
            if (value == arr[j])
                break;
        }
        if (j == nElems) return false; // Найти не удалось
        else { // Значение найдено
            for (int k = j; k < nElems - 1; k++) { // Сдвиг последующих элементов
                arr[k] = arr[k + 1];
            }
            nElems--; // Уменьшение размера
            return true;
        }
    }

    public void display() { // Вывод содержимого массива
        for (int i = 0; i < nElems; i++) {  // Для каждого элемента
            System.out.print(arr[i] + " "); // Вывод
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 100; // Размер массива

        HighArray arr; // Ссылка на массив
        arr = new HighArray(maxSize); // Создание массива

        arr.insert(77); // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.display(); // Вывод элементов

        int searchKey = 35; // Поиск элемента

        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(0); // Удаление трех элементов
        arr.delete(55);
        arr.delete(99);

        arr.display(); // Повторный вывод
    }
}
