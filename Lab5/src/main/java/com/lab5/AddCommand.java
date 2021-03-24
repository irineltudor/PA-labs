package com.lab5;

public class AddCommand extends Command {

    AddCommand(Catalog catalog)
    {
        super(catalog);
    }




    void execute(String[] params) {
        if(params[0].equals("song"))
        {
            try {
                var song = new Song(params[1] , params[2], params[3], params[4]);
                catalog.add(song);
            } catch (InvalidYearException e) {
                e.printStackTrace();
            }

        }

        if(params[0].equals("book"))

        {

            try {
                var book = new Book(params[1] , params[2], params[3], params[4]);
                catalog.add(book);
            } catch (InvalidYearException e) {
                e.printStackTrace();
            }
        }

    }
}
