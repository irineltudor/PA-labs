package com.lab5;

public abstract class Command {

    //class members
    Catalog catalog;
    //
    Command(Catalog catalog)
    {
        this.catalog=catalog;
    }
    abstract void execute(String...params);

}
