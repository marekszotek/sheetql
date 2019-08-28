package com.codecool.solosheetql.query;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class ClauseConstructor implements Consumer<String> {

    private final List<String> keywords;

    private List<Clause> readyClauses;
    private List<String> currentClauseWords;


    @Autowired
    ClauseConstructor() {
        readyClauses = new ArrayList<>();
        currentClauseWords = new ArrayList<>();
        this.keywords = loadKeywords();
    }

    private List<String> loadKeywords() {
        List<String> keywords = new ArrayList<>();
        keywords.add("SELECT");
        keywords.add("FROM");
        keywords.add("WHERE");
        return keywords;
    }

    @Override
    public void accept(String word) {
        if (keywords.contains(word.toUpperCase())) {
            // create a clause from existing words
            if (!currentClauseWords.isEmpty()) {
                readyClauses.add(createClauseFromCurrentWords());
            }
            currentClauseWords.clear();
        }
        currentClauseWords.add(word);
    }

    private Clause createClauseFromCurrentWords() {
        String keyword = currentClauseWords.get(0).toUpperCase();
        String request = String.join(" ", currentClauseWords.subList(1, currentClauseWords.size()));
        return new Clause(keyword, request);
    }

    void combine(ClauseConstructor other) {
        readyClauses.addAll(other.readyClauses);
    }

    List<Clause> getClauses() {
        readyClauses.add(createClauseFromCurrentWords());
        currentClauseWords.clear();
        return readyClauses;
    }
}
