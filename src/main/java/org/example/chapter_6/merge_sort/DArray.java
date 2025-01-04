package org.example.chapter_6.merge_sort;

import java.util.Arrays;

public class DArray {

    private final long[] theArray; // Массив, который будет отсортирован
    private int nElems; // Количество элементов данных

    public DArray(int max) { // Конструктор
        this.theArray = new long[max]; // Создание массива
        this.nElems = 0;
    }

    public void insert(long value) { // Занесение элемента в массив
        theArray[nElems++] = value; // Вставка элемента и увеличение размера
    }

    public void display() { // Вывод содержимого массива
        for (int j = 0; j < nElems; j++) { // Для каждого элемента
            System.out.print(theArray[j] + " "); // Вывод
        }
        System.out.println();
    }

    // Метод для сортировки массива
    public void mergeSort() { // Вызывается из main()
        long[] workSpace = new long[nElems]; // Создаем рабочее пространство для слияния
        mergeSort(workSpace, 0, nElems - 1); // Запускаем сортировку слиянием
    }

    // Метод, реализующий алгоритм сортировки слиянием
    private void mergeSort(long[] workSpace, int lowerBound, int upperBound) {
        System.out.println("Entering " + lowerBound + "-" + upperBound);
        // Если нижняя граница равна верхней, то массив содержит единственный элемент и уже отсортирован
        if (lowerBound == upperBound) {
            System.out.println("Base-Case Return " + lowerBound + "-" + upperBound);
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2; // Находим средний индекс
            // Рекурсивно сортируем левую половину
            System.out.println("Will sort low half of " + lowerBound + "-" + upperBound);
            mergeSort(workSpace, lowerBound, mid);
            // Рекурсивно сортируем правую половину
            System.out.println("Will sort high half of " + lowerBound + "-" + upperBound);
            mergeSort(workSpace, mid + 1, upperBound);
            // Сливаем две отсортированные половины
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    // Метод для слияния двух отсортированных подмассивов
    private void merge(long[] workSpace, int leftStart, int rightStart, int rightEnd) {
        System.out.println("Will merge halves into " + leftStart + "-" + rightEnd);
        int begin = leftStart; // Начальный индекс для записи обратно в оригинальный массив
        int workSpaceIndex = 0; // Индекс для рабочей области
        int leftEnd = rightStart - 1; // Конец левого подмассива
        int elementsCount = (rightEnd - leftStart) + 1; // Общее количество элементов для копирования

        // Сравниваем элементы из обоих подмассивов и записываем меньшие в рабочую область
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (theArray[leftStart] < theArray[rightStart]) {
                workSpace[workSpaceIndex++] = theArray[leftStart++]; // Копируем меньший элемент
            } else {
                workSpace[workSpaceIndex++] = theArray[rightStart++]; // Копируем меньший элемент
            }
        }

        // Копируем оставшиеся элементы из левого подмассива, если они есть
        while (leftStart <= leftEnd) {
            workSpace[workSpaceIndex++] = theArray[leftStart++]; // Копируем оставшиеся элементы
        }

        // Копируем оставшиеся элементы из правого подмассива, если они есть
        while (rightStart <= rightEnd) {
            workSpace[workSpaceIndex++] = theArray[rightStart++]; // Копируем оставшиеся элементы
        }

        // Записываем отсортированные элементы обратно в оригинальный массив
        for (int i = 0; i < elementsCount; i++) {
            theArray[begin + i] = workSpace[i]; // Вставляем из рабочей области обратно в оригинал
        }
        System.out.println(Arrays.toString(workSpace));
    }

    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        DArray arr; // Ссылка на массив
        arr = new DArray(maxSize); // Создание массива
        arr.insert(64); // Вставка элементов
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);
        arr.display(); // Вывод содержимого массива
        arr.mergeSort(); // Сортировка слиянием
        arr.display(); // Повторный вывод
    }
}
