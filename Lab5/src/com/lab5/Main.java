package com.lab5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, InvalidYearException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException, InvalidYearException {
        Catalog catalog =
                new Catalog("My Songs and books", "E:\\work\\Facultate\\PA-labs\\Lab5\\media\\catalog.ser");
        var song = new Song("bestSong" , "Lost", "E:\\work\\Facultate\\PA-labs\\Lab5\\media\\songs\\Lost.mp3", "2018");
        var book = new Book("bestBook" ,"Scufita Rosie", "E:\\work\\Facultate\\PA-labs\\Lab5\\media\\books\\Scufita rosie.pdf");
        catalog.add(song);
        catalog.add(book);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("E:\\work\\Facultate\\PA-labs\\Lab5\\media\\catalog.ser");
        assert catalog != null;
        catalog.list();
        CatalogUtil.view(catalog.findById("bestSong"));
        CatalogUtil.view(catalog.findById("bestBook"));

    }


}
