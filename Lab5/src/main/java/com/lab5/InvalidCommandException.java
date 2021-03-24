package com.lab5;

public class InvalidCommandException extends Exception{
    public InvalidCommandException() {
        super("Invalid command");
    }
}
