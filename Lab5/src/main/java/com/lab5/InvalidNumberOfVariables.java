package com.lab5;

public class InvalidNumberOfVariables extends Throwable {
    public InvalidNumberOfVariables(int i, String command) {
        super("Invalid number of variables : " +command + " command requires " + i + " variables" );
    }
}
