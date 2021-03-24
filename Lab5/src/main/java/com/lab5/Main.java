package com.lab5;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, InvalidYearException, InvalidNumberOfVariables, InvalidCommandException {
        Main app = new Main();
       app.testCreateSave();
       /* app.testLoadView();*/
          ShellCommands();

    }

    private void testCreateSave() throws IOException, InvalidYearException {
        Catalog catalog =
                new Catalog("My Songs and books", "E:\\work\\Facultate\\PA-labs\\Lab5\\media\\catalog.ser");
        var song = new Song("bestSong" , "Lost", "E:\\work\\Facultate\\PA-labs\\Lab5\\media\\songs\\Lost.mp3", "2018");
        var book = new Book("bestBook" ,"Scufita Rosie", "E:\\work\\Facultate\\PA-labs\\Lab5\\media\\books\\Scufita rosie.pdf","2005");
        catalog.add(song);
        catalog.add(book);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("E:\\work\\Facultate\\PA-labs\\Lab5\\media\\catalog.ser");
        assert catalog != null;
        catalog.list();
        CatalogUtil.play(catalog.findById("bestSong"));
        CatalogUtil.play(catalog.findById("bestBook"));

    }
    private static void ShellCommands() throws IOException, InvalidNumberOfVariables, InvalidCommandException, InvalidCatalogException {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();
        int validCommand = 0;
        while (true) {
            System.out.print("command>");
            validCommand = 0;
            String commandName = scanner.next();
            if (commandName.equalsIgnoreCase("exit")) {
                break;
            }
            if (commandName.equals("add")) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (params.length != 5)
                    throw new InvalidNumberOfVariables(5, "add");
                Command command = new AddCommand(catalog);
                command.execute(params[0], params[1], params[2], params[3],params[4]);
                validCommand = 1;
            }
            if (commandName.equals("list")) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (!params[0].equals(""))
                    throw new InvalidNumberOfVariables(0, "list");
                Command command = new ListCommand(catalog);
                command.execute();
                validCommand = 1;
            }
            if (commandName.equals("save")) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (params.length != 2)
                    throw new InvalidNumberOfVariables(2, "save");
                Command command = new SaveCommand(catalog);
                command.execute(params[0], params[1]);
                validCommand = 1;
            }
            if (commandName.equals("load")) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (params.length != 1)
                    throw new InvalidNumberOfVariables(1, "load");
                LoadCommand command = new LoadCommand(catalog);
                command.execute(params);
                catalog = command.load();
                validCommand = 1;
            }
            if (commandName.equals("play")) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (params.length != 1)
                    throw new InvalidNumberOfVariables(1, "play");
                Command command = new PlayCommand(catalog);
                command.execute(params);
                validCommand = 1;
            }
            if (commandName.equals("report")) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (!params[0].equals(""))
                    throw new InvalidNumberOfVariables(0, "report");
                Command command = new ReportCommand(catalog);
                command.execute();
                validCommand = 1;
            }

            if(commandName.equals("help"))
            {
                System.out.println();
                System.out.println("Commands : ");
                System.out.println("1)add <song/book> <id> <name> <path> <releaseYear>");
                System.out.println("2)list");
                System.out.println("3)load <path>");
                System.out.println("4)save <name> <path>");
                System.out.println("5)play <id>");
                System.out.println("6)report");
                System.out.println("7)exit");
                System.out.println();
                validCommand=1;

            }

            if(commandName.equals("exit"))
            {
                break;

            }
            if (validCommand == 0)
                throw new InvalidCommandException();
        }
    }

}
