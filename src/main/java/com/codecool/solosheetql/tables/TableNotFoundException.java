package com.codecool.solosheetql.tables;

public class TableNotFoundException extends Throwable {

    public TableNotFoundException(Throwable error){
        super(error);
    }

    public TableNotFoundException(String errorMessage){
        super(errorMessage);
    }

    public TableNotFoundException(String errorMessage, Throwable error){
        super(errorMessage, error);
    }

}
