package org.example;

import org.example.chapter_13.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('F');
        graph.addVertex('T');
        graph.addVertex('U');
        graph.addVertex('Z');
        graph.addEdge(1, 3);
        graph.addEdge(3, 1);
        graph.displayVertex(3);
    }
}