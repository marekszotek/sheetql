package com.codecool.solosheetql.tables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TablesController {

    private TableParser tableParser;
    private TableLoader tableLoader;

    @Autowired
    public TablesController(TableParser tableParser, TableLoader tableLoader) {
        this.tableParser = tableParser;
        this.tableLoader = tableLoader;
    }

    public Table getTable(String name) {
        String content = null;
        try {
            content = tableLoader.loadTableContent(name);
        } catch (TableNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tableParser.parseTableFromContent(content, name);
    }
}
