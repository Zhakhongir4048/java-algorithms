package org.example.chapter_3;

public class ArraySel {

    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public ArraySel(int max) { // Конструктор
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public void insert(long value) { // Вставка элемента в массив
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    public void display() { // Вывод содержимого массива
        for (int i = 0; i < nElems; i++) { // Для каждого элемента
            System.out.print(a[i] + " "); // Вывод
        }
        System.out.println();
    }

    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) { // Внешний цикл
            min = out; // Минимум
            for (in = out + 1; in < nElems; in++) { // Внутренний цикл
                if (a[in] < a[min]) // Если значение min больше,
                    min = in; // значит, найден новый минимум
            }
            swap(out, min); // Поменять их местами
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

}
