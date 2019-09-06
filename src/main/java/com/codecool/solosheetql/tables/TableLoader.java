package com.codecool.solosheetql.tables;

public interface TableLoader {

    String loadTableContent(String spreadsheetName) throws TableNotFoundException;
}
