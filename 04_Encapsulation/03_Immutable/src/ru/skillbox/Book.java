package ru.skillbox;

public class Book {
    private final String nameBook;
    private final String author;
    private final int numberOfPages;
    private final int numberISBN;

    public Book(String nameBook, String author, int numberOfPages, int numberISBN) {
        this.nameBook = nameBook;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.numberISBN = numberISBN;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getNumberISBN() {
        return numberISBN;
    }
}
