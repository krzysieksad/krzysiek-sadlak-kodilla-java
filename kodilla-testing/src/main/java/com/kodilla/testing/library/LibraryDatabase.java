package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
    // lists books having title beginning with titleFragment
    List<Book> listBooksWithCondition(final String titleFragment);

    // list books borrowed by libraryUser
    List<Book> listBooksInHandsOf(final LibraryUser libraryUser);

    // try to rent a book for libraryUser
    // returns true when success
    // and returns false when book is unavailable to rent
    boolean rentABook(final LibraryUser libraryUser, final Book book);

    // return all books borrowed by libraryUser to the library
    // returns number of books returned back
    int returnBooks(final LibraryUser libraryUser);
}
