package com.codecool.solosheetql.runner;

import com.codecool.solosheetql.query.Clause;
import com.codecool.solosheetql.tables.Table;

public class ClauseExecutor {
    public Table execute(Clause clause, Table inputTable) {
        return inputTable;
    }
}
