package com.kodilla.good.patterns.challenges;

import java.util.Collection;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class MovieStoreTestSuite {
    private MovieStore prepareTestData() {
        MovieStore newMovieStore = new MovieStore();

        newMovieStore.addMovieWithTranslation("IM", Arrays.asList("Żelazny Człowiek", "Iron Man"));
        newMovieStore.addMovieWithTranslation("AV", Arrays.asList("Mściciele", "Avengers"));
        newMovieStore.addMovieWithTranslation("FL", Arrays.asList("Błyskawica", "Flash"));

        return newMovieStore;
    }

    @Test
    public void testGetMovies() {
        //given
        MovieStore movieStore = prepareTestData();

        //when
        String movieList = movieStore.getMovies().entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));

        //then
        Assert.assertEquals("Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash", movieList);
    }
}
