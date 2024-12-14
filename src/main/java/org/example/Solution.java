package org.example;

public class Solution {


    public static int test(int n) {
        if (n == 0) return 0;
        return n + test(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(test(7));
    }
}
