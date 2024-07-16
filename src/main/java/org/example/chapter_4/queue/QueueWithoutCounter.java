package org.example.chapter_4.queue;

public class QueueWithoutCounter {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public QueueWithoutCounter(int s) { // Конструктор
        maxSize = s + 1; // Массив на одну ячейку больше требуемого размера
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long j) { // Вставка элемента в конец очереди
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    public long remove() { // Извлечение элемента в начале очереди
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        return temp;
    }

    public long peek() { // Чтение элемента в начале очереди
        return queArray[front];
    }

    public boolean isEmpty() { // true, если очередь пуста
        return (rear + 1 == front) || (front + maxSize - 1 == rear);
    }

    public boolean isFull() { // true, если очередь заполнена
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }

    public int size() { // (assumes queue not empty)
        if (rear >= front) // Непрерывная последовательность
            return rear - front + 1;
        else // Несвязная последовательность
            return (maxSize - front) + (rear + 1);
    }
}
