package org.example.chapter_6.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleRecursion {

    static int theNumber;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int triangle = triangle(theNumber);
        System.out.println("Triangle=" + triangle);
    }

    static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangle(n - 1);
        }
    }

    static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
