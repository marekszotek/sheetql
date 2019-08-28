package com.codecool.solosheetql.query;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QueryParser {

    ClauseValidator clauseValidator;

    QueryParser(ClauseValidator clauseValidator) {
        this.clauseValidator = clauseValidator;
    }

    public List<Clause> parseIntoClauses(String query){
        List<Clause> clauses = Stream.of(query.replace(";", "").split("\\s"))
                .collect(ClauseConstructor::new, ClauseConstructor::accept, ClauseConstructor::combine)
                .getClauses();

        return clauses.stream()
                .map(clause -> clauseValidator.validate(clause))
                .collect(Collectors.toList());

    }
}
