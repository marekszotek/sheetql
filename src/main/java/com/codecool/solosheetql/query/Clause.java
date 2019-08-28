package com.codecool.solosheetql.query;

import java.util.Objects;

public class Clause {
    private String keyword;
    private String request;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clause)) return false;
        Clause clause = (Clause) o;
        return keyword.equals(clause.keyword) &&
                request.equals(clause.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword, request);
    }
}
