package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {
    /**
     * Submodule 8.4.
     * @param args args
     */
    public static void main(final String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();

        if (collection.size() > 2) {
            String movie = collection.get(0);
            System.out.println(movie);

            String anotherMovie = collection.get(1);
            System.out.println(anotherMovie);
        }
    }
}
