package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieStore {
    private final Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();

    public Map<String, List<String>> getMovies() {
        return this.booksTitlesWithTranslations;
    }

    public void addMovieWithTranslation(final String shortName, final List<String> translationAndOriginalName) {
        this.booksTitlesWithTranslations.put(shortName, translationAndOriginalName);
    }
}
