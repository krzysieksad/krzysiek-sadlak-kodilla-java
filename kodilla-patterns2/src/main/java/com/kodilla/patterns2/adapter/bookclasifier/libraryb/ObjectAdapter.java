package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ObjectAdapter implements Classifier {
    private MedianAdaptee medianAdaptee;

    public ObjectAdapter(final MedianAdaptee medianAdaptee) {
        this.medianAdaptee = medianAdaptee;
    }

    @Override
    public int publicationYearMedian(final Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books = new HashMap<>();

        for (Book book : bookSet) {
            books.put(new BookSignature(book.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }

        return medianAdaptee.medianPublicationYear(books);
    }
}

