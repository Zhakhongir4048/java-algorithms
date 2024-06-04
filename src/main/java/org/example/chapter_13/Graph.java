package org.example.chapter_13;

import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 20; // Максимальное кол-во вершин
    private final Vertex[] vertexList; // Массив вершин
    private final int[][] adjMat; // Матрица смежности
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

    // Метод возвращает непосещенную вершину, смежную по отношению к v
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++)
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited) // Возвращает первую найденную вершину.
                return i;
        return -1; // Таких вершин нет
    }

    public void dfs() { // Обход в глубину.
        Stack<Integer> stack = new Stack<>();
        vertexList[0].wasVisited = true; // Алгоритм начинает с вершины 0. Пометка
        displayVertex(0); // Вывод
        stack.push(0); // Занесение в стек

        while (!stack.isEmpty()) { // Пока стек не опустеет

            int v = getAdjUnvisitedVertex(stack.peek()); // Получение непосещенной вершины, смежной к текущей

            if (v == -1) stack.pop(); // Если такой вершины нет, элемент извлекается из стека
            else { // Если вершина найдена
                vertexList[v].wasVisited = true; // Пометка
                displayVertex(v); // Вывод
                stack.push(v); // Занесение в стек
            }
        }

        // Стек пуст, работа закончена
        for (int i = 0; i < nVerts; i++)
            vertexList[i].wasVisited = false; // Сброс флагов
    }
}
