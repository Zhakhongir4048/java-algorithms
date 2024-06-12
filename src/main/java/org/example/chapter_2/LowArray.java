package org.example.chapter_2;

public class LowArray {

    private long[] a; // Ссылка на массив a

    public LowArray(int size) { // Конструктор
        a = new long[size]; // Создание массива
    }

    public void setElem(int index, long value) { // Запись элемента
        a[index] = value;
    }

    public long getElem(int index) { // Чтение элемента
        return a[index];
    }

    public static void main(String[] args) {
        LowArray arr; // Ссылка
        arr = new LowArray(100); // Создание объекта LowArray
        int nElems = 0; // Количество элементов в массиве
        int j; // Переменная цикла

        arr.setElem(0, 77); // Вставка 10 элементов
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 0);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10; // Массив содержит 10 элементов

        for (j = 0; j < nElems; j++) { // Вывод элементов
            System.out.print(STR."\{arr.getElem(j)} ");
        }
        System.out.println();


        int searchKey = 26; // Поиск элемента
        for (j = 0; j < nElems; j++) { // Для каждого элемента
            if (arr.getElem(j) == searchKey) { // Значение найдено?
                break;
            }
        }

        if (j == nElems) // Нет
            System.out.println(STR."Can't find \{searchKey}");
        else // Да
            System.out.println(STR."Found \{searchKey}");


        // Удаление элемента с ключом 55
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == 55)
                break;
        }

        for (int k = j; k < nElems - 1; k++) { // Сдвиг последующих элементов
            arr.setElem(k, arr.getElem(k + 1));
        }
        nElems--; // Уменьшение размера

        for (j = 0; j < nElems; j++) { // Вывод содержимого
            System.out.print(STR."\{arr.getElem(j)} ");
        }
        System.out.println();
    }
}
