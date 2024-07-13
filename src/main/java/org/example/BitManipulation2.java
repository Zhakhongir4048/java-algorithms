package org.example;

/**
 * Битовые сдвиги - Мы возьмем какое-то число и будем двигать его биты влево и вправо
 */
public class BitManipulation2 {

    public static void main(String[] args) {
        // Сдвиг битов влево обозначается знаком <<
        int x = 64; // Значение
        int y = 3; // Количество

        int z = (x << y);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(z));
    }
}
