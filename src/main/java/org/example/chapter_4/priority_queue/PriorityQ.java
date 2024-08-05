package org.example.chapter_4.priority_queue;

public class PriorityQ {

    // Элементы массива сортируются по значению ключа, от максимума (0) до минимума (maxSize-1)
    // Значение front всегда равно nItems-1
    // Значение rear всегда равно 0.
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s) { // Конструктор
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) { // Вставка элемента
        int j;
        if (nItems == 0) // Если очередь пуста
            queArray[nItems++] = item; // вставляем в ячейку 0
        else { // Если очередь содержит элементы
            for (j = nItems - 1; j >= 0; j--) { // Перебор в обратном направлении
                if (item > queArray[j]) // Если новый элемент больше,
                    queArray[j + 1] = queArray[j]; // сдвинуть вверх
                else // Если меньше,
                    break; // сдвиг прекращается
            }
            queArray[j + 1] = item; // Вставка элемента
            nItems++;
        }
    }

    public long remove() { // Извлечение минимального элемента
        return queArray[--nItems];
    }

    public long peekMin() { // Чтение минимального элемента
        return queArray[nItems - 1];
    }

    public boolean isEmpty() { // true, если очередь пуста
        return nItems == 0;
    }

    public boolean isFull() { // true, если очередь заполнена
        return nItems == maxSize;
    }

    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ(5);
        priorityQ.insert(30);
        priorityQ.insert(50);
        priorityQ.insert(10);
        priorityQ.insert(40);
        priorityQ.insert(20);

        while (!priorityQ.isEmpty()) {
            long item = priorityQ.remove();
            System.out.print(item + " "); // 10, 20, 30, 40, 50
        }
        System.out.println();
    }
}
