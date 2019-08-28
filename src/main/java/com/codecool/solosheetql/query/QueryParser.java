package com.codecool.solosheetql.query;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class QueryParser {

    public List<Clause> parseIntoClauses(String query){
        return Stream.of(query.replace(";", "").split("\\s"))
                .collect(ClauseConstructor::new, ClauseConstructor::accept, ClauseConstructor::combine)
                .getClauses();
    }
}
