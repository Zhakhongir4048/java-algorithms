package org.example.chapter_5;

public class Link {

    public int iData; // Данные (ключ)
    public double dData; // Данные
    public Link next; // Следующий элемент в списке

    public Link(int iData, double dData) { // Конструктор
        this.iData = iData; // Инициализация данных
        this.dData = dData; // (‘next’ автоматически присваивается null)
    }

    public void displayLink() { // Вывод содержимого элемента
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
