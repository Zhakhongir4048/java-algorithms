package org.example.chapter_13;

public class Graph {
    private final int MAX_VERTS = 20; // Максимальное кол-во вершин
    private Vertex vertexList[]; // Массив вершин
    private int adjMat[][]; // Матрица смежности
    private int nVerts; // Текущее количество вершин

    public Graph() { // Конструктор
        vertexList = new Vertex[MAX_VERTS]; // Инициализируем массив вершин
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // Матрица смежности. N*N
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // Матрица смежности заполняется нулями
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = 0;
    }

    public void addVertex(char lab) { // В аргументе передается метка
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
}
