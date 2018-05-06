package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ObjectAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //given
        MedianAdaptee medianAdaptee = new MedianAdaptee();
        ObjectAdapter objectAdapter = new ObjectAdapter(medianAdaptee);
        Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet = new HashSet<>();
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author1", "title1", 1985, "signature1"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author2", "title2", 1054, "signature2"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author3", "title3", 2015, "signature3"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author4", "title4", 1222, "signature4"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author5", "title5", 1998, "signature5"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author6", "title6", 1936, "signature6"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author7", "title7", 2018, "signature7"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author8", "title8", 2000, "signature8"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclasifier.librarya.Book("author9", "title9", 1999, "signature9"));
        bookSet.add(new Book("author10", "title10", 1486, "signature10"));

        //when
        int median = objectAdapter.publicationYearMedian(bookSet);

        //then
        System.out.println(median);
        assertEquals(1998, median, 0);
    }
}