package com.codecool.solosheetql.tables;

import java.util.List;
import java.util.Map;

public class Table {

    private String name;
    private Map<String, Integer> headers;
    private List<List<String>> records;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Integer> headers) {
        this.headers = headers;
    }

    public List<List<String>> getRecords() {
        return records;
    }

    public void setRecords(List<List<String>> records) {
        this.records = records;
    }
}
