package org.example.chapter_2.example;

public class ArrayApp {

    public static void main(String[] args) {
        long[] arr = new long[100]; // Создание массива
        int nElems; // Количество элементов
        int j; // Счетчик цикла
        long searchKey; // Ключ искомого элемента

        arr[0] = 77; // Вставка 10 элементов
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 0;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10; // Массив содержит 10 элементов

        for (j = 0; j < nElems; j++) // Вывод элементов
            System.out.print(arr[j] + " ");
        System.out.println();
        // ------------------------------------------------

        searchKey = 66; // Поиск элемента с ключом 66
        for (j = 0; j < nElems; j++) // Для каждого элемента
            if (arr[j] == searchKey) // Значение найдено?
                break; // Да - выход из цикла

        if (j == nElems) // Достигнут последний элемент?
            System.out.println("Can't find " + searchKey); // Да
        else
            System.out.println("Found " + searchKey); // Нет
        // ------------------------------------------------

        searchKey = 55; // Удаление элемента с ключом 55
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey) { // Поиск удаляемого элемента
                break;
            }
        }
        // k = j, сделано для того, чтобы понять, где дыра, и откуда начать сдвиг последующих элементов
        for (int k = j; k < nElems - 1; k++) { // Сдвиг последующих элементов
            arr[k] = arr[k + 1]; // То есть правый элемент идёт влево, пустую ячейку так заполняем
        }
        nElems--; // Уменьшение размера

        for (j = 0; j < nElems; j++) { // Вывод элементов
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
