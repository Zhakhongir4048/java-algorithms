package org.example.chapter_4.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketChecker {

    private String input; // Входная строка

    public BracketChecker(String input) { // Конструктор
        this.input = input;
    }

    public void check() {
        int stackSize = input.length(); // Определение размера стека
        StackX<Character> stackX = new StackX<>(stackSize); // Создание стека
        for (int i = 0; i < input.length(); i++) { // Последовательное чтение
            char c = input.charAt(i); // Чтение символа
            switch (c) {
                case '[': // Открывающие скобки
                case '{':
                case '(':
                    stackX.push(c); // Занести в стек
                    break;
                case ']': // Закрывающие скобки
                case '}':
                case ')':
                    if (!stackX.isEmpty()) { // Если стек не пуст
                        char c1 = stackX.pop(); // Извлечь и проверить
                        if (c == ']' && c1 != '[' || c == '}' && c1 != '{' || c == ')' && c1 != '(') {
                            System.out.println("Error: " + c + " at " + i);
                        }
                    } else { // Преждевременная нехватка элементов
                        System.out.println("Error: " + c + " at " + i);
                    }
                    break;
                default: // Для других символов действия не выполняются
                    break;
            }
        }

        // В этой точке обработаны все символы
        if (!stackX.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = getString(); // Чтение строки с клавиатуры
            if (input.isEmpty()) { // Завершение, если [Enter]
                break;
            }
            BracketChecker theChecker = new BracketChecker(input); // Создание объекта BracketChecker
            theChecker.check(); // Проверка парных скобок
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
