package org.example.chapter_6.binary_search;

public class BinarySearchRec {

    private long[] a; // Ссылка на массив a
    private int nElems; // number of data items

    public BinarySearchRec(int max) { // Конструктор
        a = new long[max]; // Создание массива
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == searchKey)
            return curIn; // Элемент найден
        else if (lowerBound > upperBound)
            return nElems; // Элемент не найден
        else if (a[curIn] < searchKey) // Деление диапазона
            return recFind(searchKey, curIn + 1, upperBound); // В верхней половине
        else return recFind(searchKey, lowerBound, curIn - 1); // В нижней половине
    }

    /**
     * Сначала ищется индекс, куда вставим новый элемент.
     * То есть, первый элемент, который больше вставляемого.
     * Затем мы делаем перестановку, идём вправо, забирая слева элементы. Делаем дыру для вставки
     */
    public void insert(long value) { // Сохранение элемента в массиве
        int indexForAdd;
        for (indexForAdd = 0; indexForAdd < nElems; indexForAdd++) // Определение позиции
            if (a[indexForAdd] > value) // (линейный поиск)
                break;
        for (int k = nElems; k > indexForAdd; k--) { // Перемещение элементов
            a[k] = a[k - 1]; // с большим значением ключа
        }
        a[indexForAdd] = value; // Вставка
        nElems++; // Увеличение размера
    }

    public void display() { // Вывод содержимого массива
        for (int j = 0; j < nElems; j++) { // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод текущего элемента
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        BinarySearchRec arr = new BinarySearchRec(maxSize); // Создание массива

        arr.insert(72); // Вставка элементов
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);

        arr.display(); // Вывод содержимого массива

        int searchKey = 27; // Поиск элемента
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can’t find " + searchKey);
        }
    }
}
