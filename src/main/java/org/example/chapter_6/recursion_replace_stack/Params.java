package org.example.chapter_6.recursion_replace_stack;

public class Params { // Параметры, сохраняемые в стеке

    public int n;
    public int returnAddress;

    public Params(int n, int returnAddress) {
        this.n = n;
        this.returnAddress = returnAddress;
    }
}
