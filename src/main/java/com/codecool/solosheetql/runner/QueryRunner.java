package com.codecool.solosheetql.runner;

import com.codecool.solosheetql.query.Clause;
import com.codecool.solosheetql.query.QueryParser;
import com.codecool.solosheetql.tables.Table;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryRunner {

    private QueryParser queryParser;
    private ClauseExecutor clauseExecutor;


    Table getResultTableFromQuery(String query){
        List<Clause> clauses = queryParser.parseIntoClauses(query);
        return clauseExecutor.execute(clauses);
    }
}
