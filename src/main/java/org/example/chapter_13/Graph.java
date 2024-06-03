package org.example.chapter_13;

public class Graph {
    private static final int MAX_VERTS = 20; // Максимальное кол-во вершин
    private Vertex[] vertexList; // Массив вершин
    private int[][] adjMat; // Матрица смежности
    private int nVerts; // Текущее количество вершин

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // Матрица смежности. N*N
        nVerts = 0;
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat.length; j++) {
                adjMat[i][j] = 0;
            }
        }
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
