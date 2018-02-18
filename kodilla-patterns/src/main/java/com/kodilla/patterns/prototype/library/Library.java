package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private final String name;
    private final Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
