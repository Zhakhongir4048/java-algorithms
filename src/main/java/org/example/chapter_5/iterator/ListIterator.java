package org.example.chapter_5.iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListIterator {

    private Link current;
    private Link previous;
    private LinkList ourList;

    ListIterator(LinkList list) {
        this.ourList = list;

    }

    void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    boolean atEnd() {
        return current.next == null;
    }

    void nextLink() {
        previous = current;
        current = current.next;
    }

    Link getCurrent() {
        return this.current;
    }

    void insertAfter(long dData) {
        Link newLink = new Link(dData);
        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    void insertBefore(long dData) {
        Link newLink = new Link(dData);
        if (previous == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    long deleteCurrent() {
        long value = current.dData;
        if (previous == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        LinkList theList = new LinkList(); //
        ListIterator iter1 = theList.getIterator();
        long value;

        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertAfter(60);

        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's' -> {
                    if (!theList.isEmpty())
                        theList.displayList();
                    else
                        System.out.println("List is empty");
                }
                case 'r' -> iter1.reset();
                case 'n' -> {
                    if (!theList.isEmpty() && !iter1.atEnd()) {
                        iter1.nextLink();
                    } else {
                        System.out.println("Can’t go to next link");
                    }
                }
                case 'g' -> {
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned " + value);
                    }
                    else
                        System.out.println("List is empty");
                }
                case 'b' -> {
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                }
                case 'a' -> {
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                }
                case 'd' -> {
                    if (!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Invalid entry");
                    }
                }
                default -> System.out.println("Invalid entry");
            }
        }
    }

    static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
