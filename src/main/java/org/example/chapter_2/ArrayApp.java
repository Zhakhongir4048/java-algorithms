package org.example.chapter_2;

public class ArrayApp {

    public static void main(String[] args) {
        long[] arr; // Ссылка на массив
        arr = new long[100]; // Создание массива
        int nElems = 0; // Количество элементов
        int j; // Счетчик цикла
        long searchKey; // Ключи искомого элемента

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
            System.out.print(STR."\{arr[j]} ");
        System.out.println();

        searchKey = 88; // Поиск элемента с ключом 66
        for (j = 0; j < nElems; j++) // Для каждого элемента
            if (arr[j] == searchKey) // Значение найдено?
                break; // Да - выход из цикла

        if (j == nElems) // Достигнут последний элемент?
            System.out.println(STR."Can't find \{searchKey}"); // Да
        else
            System.out.println(STR."Found \{searchKey}"); // Нет
    }
}
