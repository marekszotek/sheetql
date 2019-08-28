package com.codecool.solosheetql.tables;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TableParser {


     Table parseTableFromContent(String content, String tableName) {
        Table table = new Table();
        table.setName(tableName);

         String[] contentLines = content.split("\n");
         table.setHeaders(Arrays.stream(contentLines[0].split(", "))
                 .collect(Collectors.toList()));

         table.setRecords(Arrays
                 .stream(Arrays.copyOfRange(contentLines, 1, contentLines.length))
                 .map(s -> s.split(", "))
                 .map(Arrays::asList)
                 .collect(Collectors.toList()));

         return table;
    }
}
