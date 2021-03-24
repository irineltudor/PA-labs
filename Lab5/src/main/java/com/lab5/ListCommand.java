package com.lab5;

public class ListCommand extends Command {
    //Class Methods
    ListCommand(Catalog catalog)
    {
        super(catalog);
    }

    @Override
    void execute(String[] param) {
          catalog.list();
    }


}
