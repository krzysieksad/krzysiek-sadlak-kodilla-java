package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final LocalDate publicationDate;

    /**
     * Create new Book.
     * @param title title
     * @param author author
     * @param publicationDate publication date
     */
    public Book(final String title, final String author, final LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
