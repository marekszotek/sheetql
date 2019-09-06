package com.codecool.solosheetql.httpcontroller;

public class Query {
    private String text;

    public Query() {
    }

    public Query(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
