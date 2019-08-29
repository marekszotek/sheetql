package com.codecool.solosheetql.tables;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TablesRepository {

    Map<String, String> spreadsheetsIds;

    public TablesRepository() {
        this.spreadsheetsIds = loadSpreadsheetIds();
    }

    private Map<String, String> loadSpreadsheetIds() {
        Map<String, String> spreadsheetIds = new HashMap<>();
        spreadsheetIds.put("users", "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms");
        spreadsheetIds.put("albums", "19y6w-X3xT4undl8bea99rGiKnUXQrP8EkGWAEFrUOUI");
        return spreadsheetIds;
    }

    String getSpreadsheetId(String spreadsheetName) {
        return spreadsheetsIds.get(spreadsheetName);
    }
}
