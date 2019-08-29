package com.codecool.solosheetql.runner;

import com.codecool.solosheetql.query.Clause;
import com.codecool.solosheetql.query.QueryParser;
import com.codecool.solosheetql.tables.Table;
import org.springframework.stereotype.Controller;

import java.util.*;
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
//        List<Clause> clauses = queryParser.parseIntoClauses(query);
//        clauses = sortClauses(clauses);
//
//        Table identityTable = new Table();
//
//        return clauses.stream()
//                .reduce(identityTable, ((table, clause) -> {
//                        return clauseExecutor.execute(clause, table);
//                }), (table, table2) -> table2);

        Table dummyTable = new Table();

        List<String> headers = Arrays.asList("id", "name", "age");
        dummyTable.setHeaders(headers);

        List<List<String>> records = Arrays.asList(
                Arrays.asList("1", "Jarek", "33"),
                Arrays.asList("2", "Darek", "22"),
                Arrays.asList("3", "Marek", "44"),
                Arrays.asList("4", "Czarek", "11"),
                Arrays.asList("5", "Arek", "15"),
                Arrays.asList("6", "Komarek", "51")
        );
        dummyTable.setRecords(records);

        return dummyTable;
    }


    private List<Clause> sortClauses(List<Clause> clauses) {
        return clauses.stream()
                .sorted(Comparator.comparingInt(o -> clausePriority.get(o.getKeyword())))
                .collect(Collectors.toList());
    }
}
