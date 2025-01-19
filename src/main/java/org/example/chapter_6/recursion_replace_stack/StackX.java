package org.example.chapter_6.recursion_replace_stack;

import java.util.Arrays;

public class StackX {

    private int maxSize; // Размер массива StackX
    private Params[] stackArray;
    private int top; // Вершина стека

    public StackX(int maxSize) { // Конструктор
        this.maxSize = maxSize; // Определение размера массива
        stackArray = new Params[maxSize]; // Создание массива
        top = -1; // Массив пока не содержит элементов
    }

    public void push(Params value) { // Размещение элемента на вершине стека
        stackArray[++top] = value; // Увеличение top, вставка элемента
    }

    public Params pop() { // Извлечение элемента с вершины стека
        return stackArray[top--]; // Обращение к элементу, уменьшение top
    }

    public Params peek() { // Чтение элемента на вершине стека
        return stackArray[top];
    }

    @Override
    public String toString() {
        return Arrays.toString(stackArray);
    }
}
