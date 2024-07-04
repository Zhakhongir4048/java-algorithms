package org.example.chapter_3;


public class ArrayBub {

    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public ArrayBub(int max) { // Конструктор
        this.a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public void insert(long value) { // Вставка элемента в массив
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    public void display() { // Вывод содержимого массива
        for (int j = 0; j < nElems; j++) { // Для каждого элемента
            System.out.print(STR."\{a[j]} "); // Вывод
        }
        System.out.println();
    }

    public void bubbleSort(long[] nums) {
        int in, out;
        for (out = nums.length - 1; out >= 1; out--) { // Внешний цикл (обратный)
            for (in = 0; in < out; in++) { // Внутренний цикл (прямой)
                if (nums[in] > nums[in + 1]) { // Порядок нарушен?
                    swap(in, in + 1, nums); // Поменять местами
                }
            }
        }
    }

    public void swap(int one, int two, long[] nums) {
        long temp = a[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }
}
