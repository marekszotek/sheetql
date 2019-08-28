package com.codecool.solosheetql.runner;

import com.codecool.solosheetql.query.Clause;
import com.codecool.solosheetql.tables.Table;

import java.util.List;

public class ClauseExecutor {
    public Table execute(List<Clause> clauses) {
        return new Table();
    }
}
