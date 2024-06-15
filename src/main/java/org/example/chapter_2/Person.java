package org.example.chapter_2;

import java.util.Objects;

public class Person {

    private final String lastName;
    private final String firstName;
    private final int age;

    public Person(String lastName, String firstName, int age) { // Конструктор
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.print(STR." Last name: \{lastName}");
        System.out.print(STR.", First name: \{firstName}");
        System.out.println(STR.", Age: \{age}");
    }

    public String getLastName() { // Получение фамилии
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }
}
