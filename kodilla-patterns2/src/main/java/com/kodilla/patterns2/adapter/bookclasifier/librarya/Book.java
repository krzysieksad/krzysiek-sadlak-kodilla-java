package com.kodilla.patterns2.adapter.bookclasifier.librarya;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    /**
     * Task 20.5. Book definition.
     *
     * @param author          author
     * @param title           book title
     * @param publicationYear released in year
     * @param signature       signature
     */
    public Book(final String author, final String title, final int publicationYear, String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }
}
