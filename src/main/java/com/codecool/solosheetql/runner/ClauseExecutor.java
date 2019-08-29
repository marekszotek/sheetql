package com.codecool.solosheetql.runner;

import com.codecool.solosheetql.query.Clause;
import com.codecool.solosheetql.tables.Table;
import com.codecool.solosheetql.tables.TableNotFoundException;
import com.codecool.solosheetql.tables.TablesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ClauseExecutor {

    TablesController tablesController;

    @Autowired
    public ClauseExecutor(TablesController tablesController) {
        this.tablesController = tablesController;
    }

    Table execute(Clause clause, Table inputTable) throws TableNotFoundException {
        switch (clause.getKeyword()){
            case "FROM":
                return tablesController.getTable(clause.getRequest());
            case "SELECT":
                return inputTable;
            case "WHERE":
                return inputTable;
            default:
                return inputTable;
        }
    }
}
