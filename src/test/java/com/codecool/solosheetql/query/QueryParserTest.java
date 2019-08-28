package com.codecool.solosheetql.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@SpringBootTest
class QueryParserTest {

    @Autowired
    QueryParser queryParser;

    @Test
    public void testIfSplitIntoSelectFromWhereCorrect(){
        String query = "select * from users where age > 25";

        Clause selectClause = new Clause("SELECT", "*");
        Clause fromClause = new Clause("FROM", "users");
        Clause whereClause = new Clause("WHERE", "age > 25");

        List<Clause> expectedClauses = Arrays.asList(selectClause, fromClause, whereClause);

        List<Clause> resultClauses = queryParser.parseIntoClauses(query);

        assertThat(resultClauses, containsInAnyOrder(selectClause, fromClause, whereClause));


    }

}