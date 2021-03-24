package com.lab5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command {
    SaveCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    void execute(String... params) {
           catalog.setName(params[0]);
            try (var oos = new ObjectOutputStream(new FileOutputStream(params[1]))) {
                oos.writeObject(catalog);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
