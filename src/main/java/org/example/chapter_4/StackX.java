package org.example.chapter_4;

public class StackX {

    private int maxSize; // Размер массива
    private long[] stackArray;
    private int top; // Вершина стека

    public StackX(int size) { // Конструктор
        stackArray = new long[size]; // Создание массива
        maxSize = size; // Определение размера стека
        top = -1; // Пока нет ни одного элемента
    }

    /**
     * Это одно и тоже.
     *     public void push(long value) {
     *         stackArray[++top] = value;
     *     }
     */
    public void push(long value) { // Размещение элемента на вершине стека
        top++; // Увеличение top
        stackArray[top] = value; // Вставка элемента
    }

    /**
     * Это одно и тоже.
     *     public long pop() {
     *         return stackArray[top--];
     *     }
     */
    public long pop() { // Извлечение элемента с вершины стека
        long v = stackArray[top]; // Извлечение элемента
        top--; // Уменьшение top
        return v;
    }

    public long peek() { // Чтение элемента с вершины стека
        return stackArray[top];
    }

    public boolean isEmpty() { // True, если стек пуст
        return (top == -1);
    }

    public boolean isFull() { // True, если стек полон
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        StackX stack = new StackX(10); // Создание нового стека
        stack.push(20); // Занесение элементов в стек
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) { // Пока стек не станет пустым
            long pop = stack.pop(); // Удалить элемент из стека
            System.out.print(STR."\{pop} "); // Вывод содержимого
        }
        System.out.println();
    }
}
