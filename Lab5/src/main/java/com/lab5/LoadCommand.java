package com.lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command {
   private String path;
    LoadCommand(Catalog catalog)
    {
        super(catalog);
    }


    @Override
    public void execute(String[] params) {
         this.path=params[0];
    }

    public Catalog load() throws InvalidCatalogException {


        try {
            FileInputStream fin = new FileInputStream(this.path);
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(fin);
                this.catalog = (Catalog) in.readObject();
                in.close();
                return this.catalog;
            }
            catch (IOException ex) {

                throw new InvalidCatalogException(ex);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
