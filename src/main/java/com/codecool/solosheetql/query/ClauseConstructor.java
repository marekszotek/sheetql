package com.codecool.solosheetql.query;

import java.util.List;
import java.util.function.Consumer;

public class ClauseConstructor implements Consumer<String> {

    public void accept(String word) {
    }

    void combine(ClauseConstructor other) {
    }

    public List<Clause> getClauses() {
        return null;
    }
}
