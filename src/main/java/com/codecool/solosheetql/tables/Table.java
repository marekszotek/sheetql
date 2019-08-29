package com.codecool.solosheetql.tables;

import java.util.List;
import java.util.stream.Collectors;

public class Table {

    private String title;
    private String name;
    private List<String> headers;
    private List<List<String>> records;

    public Table() {
        title = "DEVOPS TEST";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getRecords() {
        return records;
    }

    public void setRecords(List<List<String>> records) {
        this.records = records;
    }

    public String display(){
        return headers.stream()
                .collect(Collectors.joining(" , ", "", "\n")) +
                records.stream()
                        .map(strings -> String.join(" , ", strings))
                        .collect(Collectors.joining("\n"));
    }

    public String displayHead(){
        return headers.stream()
                .collect(Collectors.joining(" , ", "", "\n")) +
                records.stream()
                        .map(strings -> String.join(" , ", strings))
                        .limit(5)
                        .collect(Collectors.joining("\n"));
    }
}
