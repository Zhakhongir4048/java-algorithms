package org.example.chapter_13;

public class Vertex {

    public char label; // Метка (например 'A')
    public boolean wasVisited; // Посещена ли вершина?

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}
