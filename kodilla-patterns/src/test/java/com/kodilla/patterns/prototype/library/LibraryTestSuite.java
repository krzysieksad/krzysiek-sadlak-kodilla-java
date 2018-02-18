package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    private void prepareBooks(final Library library) {
        IntStream.iterate(1, n -> n + 1)
                .limit(20)
                .forEach(n -> library.getBooks().add(new Book("Book #" + n, "Author #" + n, LocalDate.of(1990, 1, n))));
    }

    @Test
    public void testGetBooks() {
        //given
        Library library = new Library("First Library");

        //when
        prepareBooks(library);
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Cloned Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Third Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        library.getBooks().add(new Book("New Book", "New Author", LocalDate.of(1990, 1, 5)));

        //then
        Assert.assertEquals(21, library.getBooks().size());
        Assert.assertEquals(21, clonedLibrary.getBooks().size());
        Assert.assertEquals(20, deepClonedLibrary.getBooks().size());
    }
}
