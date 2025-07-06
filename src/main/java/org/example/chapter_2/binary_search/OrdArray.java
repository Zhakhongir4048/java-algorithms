package org.example.chapter_2.binary_search;

public class OrdArray {

    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public OrdArray(int max) { // Конструктор
        a = new long[max]; // Создание массива
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn; // Элемент найден
            } else if (lowerBound > upperBound) {
                return -1; // Элемент не найден
            } else { // Деление диапазона
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;  // В верхней половине
                } else {
                    upperBound = curIn - 1; // В нижней половине
                }
            }
        }
    }

    /**
     * 🔍 Цель алгоритма:
     * Найти первый элемент, который строго больше searchKey, и вернуть его индекс.
     * Если таких нет — вернуть nElems, то есть вставить в конец.
     * 📌 Разбор по шагам:
     * int low = 0;
     * int high = nElems - 1;
     * Ты начинаешь с диапазона [low, high], охватывающего все заполненные элементы массива.
     * <p>
     * Важно: цикл работает, пока low < high, т.е. поиск сужает левую границу,
     * пока она не упрётся в правильную позицию вставки.
     * <p>
     * Если a[mid] <= searchKey, значит searchKey точно не раньше mid, нужно искать справа ⇒ low = mid + 1
     * Если a[mid] > searchKey, то возможно это и есть позиция вставки ⇒ high = mid
     * 👉 Таким образом, диапазон сужается к первому индексу, где a[i] > searchKey
     * Когда low == high, цикл завершается, и low указывает на нужную позицию.
     * <p>
     * 🔢 Примеры:
     * Пример 1:
     * Массив: [10, 20, 30, 40]
     * searchKey = 25
     * <p>
     * mid = 1 → a[mid] = 20 <= 25 → low = 2
     * mid = 2 → a[mid] = 30 > 25 → high = 2
     * Цикл завершён → low = 2 → Вставлять перед 30
     */
    public int findInsertIndex(long searchKey) {
        int low = 0;
        int high = nElems - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] <= searchKey) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // позиция, куда можно вставить
    }

    /**
     * Сначала ищется индекс, куда вставим новый элемент.
     * То есть, первый элемент, который больше вставляемого.
     * Затем мы делаем перестановку, идём вправо, забирая слева элементы. Делаем дыру для вставки
     */
    public void insert(long value) { // Вставка элемента в массив
        int insertIndex = findInsertIndex(value); // Определение позиции вставки

        for (int k = nElems; k > insertIndex; k--) { // Перемещение последующих элементов
            a[k] = a[k - 1];
        }

        a[insertIndex] = value; // Вставка
        nElems++; // Увеличение размера
    }

    public boolean delete(long value) {
        int deleteIndex = find(value); // Двоичный поиск
        if (deleteIndex == -1) // Найти не удалось
            return false;
        else { // Элемент найден
            for (int k = deleteIndex; k < nElems; k++) { // Перемещение последующих элементов
                a[k] = a[k + 1];
            }
            nElems--; // Уменьшение размера
        }
        return true;
    }

    public void display() { // Вывод содержимого массива
        for (int j = 0; j < nElems; j++) { // Перебор всех элементов
            System.out.print(a[j] + " "); // Вывод текущего элемента
        }
        System.out.println();
    }

}
