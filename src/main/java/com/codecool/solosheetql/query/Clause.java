package com.codecool.solosheetql.query;

public class Clause {
    private String keyword;
    private String request;

    public Clause() {
    }

    public Clause(String keyword, String request) {
        this.keyword = keyword;
        this.request = request;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
