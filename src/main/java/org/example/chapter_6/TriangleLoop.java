package org.example.chapter_6;

public class TriangleLoop {

    public static void main(String[] args) {
        System.out.println(triangle(4));
    }

    static int triangle(int n) {
        int total = 0;
        while (n > 0) { // Пока n равно 1 и более
            total = total + n; // Переменная total увеличивается на n (высоту столбца)
            --n; // Переменная total увеличивается на n (высоту столбца)
        }
        return total;
    }
}
