package com.codecool.solosheetql.runner;

import com.codecool.solosheetql.query.Clause;
import com.codecool.solosheetql.query.QueryParser;
import com.codecool.solosheetql.tables.Table;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class QueryRunner {

    private QueryParser queryParser;
    private ClauseExecutor clauseExecutor;
    private final Map<String, Integer> clausePriority;

    public QueryRunner(QueryParser queryParser, ClauseExecutor clauseExecutor) {
        this.queryParser = queryParser;
        this.clauseExecutor = clauseExecutor;
        clausePriority = loadClausePriority();
    }

    private Map<String, Integer> loadClausePriority() {
        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("FROM", 1);
        priorities.put("WHERE", 2);
        priorities.put("SELECT", 3);
        return priorities;
    }

    public Table getResultTableFromQuery(String query) {
        List<Clause> clauses = queryParser.parseIntoClauses(query);
        clauses = sortClauses(clauses);

        Table identityTable = new Table();

        return clauses.stream()
                .reduce(identityTable, ((table, clause) -> clauseExecutor.execute(clause, table)), (table, table2) -> table2);
    }

    private List<Clause> sortClauses(List<Clause> clauses) {
        return clauses.stream()
                .sorted(Comparator.comparingInt(o -> clausePriority.get(o.getKeyword())))
                .collect(Collectors.toList());
    }
}
