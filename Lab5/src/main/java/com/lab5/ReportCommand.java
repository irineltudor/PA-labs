package com.lab5;

import freemarker.template.*;
import org.apache.maven.shared.utils.cli.shell.Shell;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;

public class ReportCommand extends Command {
    public ReportCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    void execute(String... params) {
        Configuration cfg = new Configuration();
        try {
            cfg.setDirectoryForTemplateLoading(new File(Shell.class.getResource("/templates").toURI()));
            Template template = cfg.getTemplate("catalog.ftl");
            Writer write = new FileWriter("E:\\work\\Facultate\\PA-labs\\Lab5\\media\\output.html");
            template.process(this.catalog, write );
            try {

                File myFile = new File("E:\\work\\Facultate\\PA-labs\\Lab5\\media\\output.html");
                Desktop.getDesktop().browse(myFile.toURI());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException | TemplateException | URISyntaxException e) {
            e.printStackTrace();
        }




    }


}
