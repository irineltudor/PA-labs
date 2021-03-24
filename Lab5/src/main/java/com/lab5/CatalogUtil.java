package com.lab5;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CatalogUtil implements Serializable {
    //Class members

    //Class methods
    //Constructor

    //Function
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }
    public static Catalog load(String path)
            throws InvalidCatalogException {
        try {
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream in;
            Catalog catalog;
            try {
                in = new ObjectInputStream(fin);
                catalog = (Catalog) in.readObject();
                in.close();
                return catalog;
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

        public static void play(Item item) {
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File(item.getLocation());
                desktop.open(myFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            //… browse or open, depending of the location type
    }


}
