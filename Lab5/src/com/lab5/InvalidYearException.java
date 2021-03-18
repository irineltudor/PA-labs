package com.lab5;

public class InvalidYearException extends Exception{
    public InvalidYearException(String name) {
        super("Invalid year for '" + name + "' song");
    }
}
