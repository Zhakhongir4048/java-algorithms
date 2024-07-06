package org.example.chapter_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser {

    private final String input; // Входная строка

    public Reverser(String input) { // Конструктор
        this.input = input;
    }

    public String doRev() { // Перестановка символов
        int stackSize = input.length(); // Определение размера стека
        StackX<Character> stackChar = new StackX<>(stackSize); // Создание стека

        for (int i = 0; i < stackSize; i++) {
            char value = input.charAt(i); // Чтение символа из входного потока
            stackChar.push(value); // Занесение в стек
        }

        StringBuilder builder = new StringBuilder();
        while (!stackChar.isEmpty()) {
            Character pop = stackChar.pop(); // Извлечение символа из стека
            builder.append(pop); // Присоединение к выходной строке
        }
        return builder.toString(); // Выходная строка
    }

    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString(); // Чтение строки с клавиатуры
            if (input.isEmpty()) // Завершение, если [Enter]
                break;
            Reverser reverser = new Reverser(input); // Создание объекта Reverser
            output = reverser.doRev(); // Использование
            System.out.println(STR."Reversed: \{output}");
        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
