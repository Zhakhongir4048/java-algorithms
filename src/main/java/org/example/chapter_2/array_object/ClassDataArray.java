package org.example.chapter_2.array_object;

public class ClassDataArray {

    private Person[] a; // Ссылка на массив
    private int nElems; // Количество элементов данных

    public ClassDataArray(int max) { // Конструктор
        a = new Person[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public Person find(String searchName) {
        int j; // Поиск заданного значения
        for (j = 0; j < nElems; j++) { // Для каждого элемента
            if (a[j].getLastName().equals(searchName)) { // Значение найдено?
                break; // Выход из цикла
            }
        }
        if (j == nElems) // Достигнут последний элемент?
            return null; // Да, значение не найдено
        else
            return a[j]; // Нет, значение найдено
    }

    // Включение записи в массив
    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++; // Увеличение размера
    }

    public boolean delete(String searchName) {
        int j; // Удаление из массива
        for (j = 0; j < nElems; j++) { // Поиск удаляемого элемента
            if (a[j].getLastName().equals(searchName))
                break;
        }
        if (j == nElems) // Найти не удалось
            return false;
        else { // Значение найдено
            for (int k = j; k < nElems; k++) { // Сдвиг последующих элементов
                a[k] = a[k + 1];
            }
            nElems--; // Уменьшение размера
            return true;
        }
    }

    public void displayA() { // Вывод содержимого массива
        for (int j = 0; j < nElems; j++) {  // Для каждого элемента
            a[j].displayPerson(); // Вывод
        }
    }


}
