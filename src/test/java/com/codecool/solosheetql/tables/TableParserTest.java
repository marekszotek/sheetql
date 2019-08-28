package com.codecool.solosheetql.tables;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TableParserTest {

    @Autowired
    TableParser tableParser;

    @Test
    public void testIfParsesCorrectTableFromContent(){
        String tableName = "Users";
        String content = "id, name, age\n" +
                "1, Jarek, 33\n" +
                "2, Darek, 22\n" +
                "3, Marek, 44";

        List<String> expectedHeaders = Arrays.asList("id", "name", "age");
        List<List<String>> expectedRecords = Arrays.asList(
                Arrays.asList("1", "Jarek", "33"),
                Arrays.asList("2", "Darek", "22"),
                Arrays.asList("3", "Marek", "44")
        );

        Table resultTable = tableParser.parseTableFromContent(content, tableName);

        assertEquals(tableName, resultTable.getName());
        assertEquals(expectedHeaders, resultTable.getHeaders());
        assertEquals(expectedRecords, resultTable.getRecords());

    }

}