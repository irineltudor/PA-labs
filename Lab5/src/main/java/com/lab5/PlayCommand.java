package com.lab5;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayCommand extends Command {
    PlayCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    void execute(String[] params) {
        Item item=catalog.findById(params[0]);
        try {
            Desktop desktop = Desktop.getDesktop();
            File myFile = new File(item.getLocation());
            desktop.open(myFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
