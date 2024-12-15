package org.example;

public class Solution {


    public static int test(int n) {
        if (n == 0) return 0;
        return n + test(n - 1);
    }

    public boolean isLetterOrDigit(char c) {
        return (((c >= '0') && (c <= '9')) || (c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z'));
    }

    public static char toLowerCase(char c) {
        return (c >= 'A' && c <= 'Z') ? (char) ('a' + (c - 'A')) : c;
    }

    public static void main(String[] args) {
        System.out.println(test(7));
    }
}
