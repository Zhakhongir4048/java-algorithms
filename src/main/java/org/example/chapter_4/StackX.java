package org.example.chapter_4;

public class StackX<T> {

    private int maxSize; // Размер массива
    private T[] stackArray;
    private int top; // Вершина стека

    public StackX(int size) { // Конструктор
        stackArray = (T[]) new Object[size]; // Создание массива
        maxSize = size; // Определение размера стека
        top = -1; // Пока нет ни одного элемента
    }

    /**
     * Это одно и тоже.
     * public void push(long value) {
     * stackArray[++top] = value;
     * }
     */
    public void push(T value) { // Размещение элемента на вершине стека
        top++; // Увеличение top
        stackArray[top] = value; // Вставка элемента
    }

    /**
     * Это одно и тоже.
     * public long pop() {
     * return stackArray[top--];
     * }
     */
    public T pop() { // Извлечение элемента с вершины стека
        T v = stackArray[top]; // Извлечение элемента
        top--; // Уменьшение top
        return v;
    }

    public T peek() { // Чтение элемента с вершины стека
        return stackArray[top];
    }

    public boolean isEmpty() { // True, если стек пуст
        return (top == -1);
    }

    public boolean isFull() { // True, если стек полон
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        StackX<Integer> stack = new StackX<>(10); // Создание нового стека
        stack.push(20); // Занесение элементов в стек
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) { // Пока стек не станет пустым
            Integer pop = stack.pop(); // Удалить элемент из стека
            System.out.print(STR."\{pop} "); // Вывод содержимого
        }
        System.out.println();
    }
}
