package com.lab8.tools;

import com.lab8.objects.MovieReport;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

public class Report {
    MovieReport report;
    int id;

    public Report(int id) throws SQLException {
        this.id = id;
        report = new MovieReport(id);
    }

    public void Run() {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
            configuration.setDirectoryForTemplateLoading(new File(".\\src\\main\\resources\\templates"));
            Template template = configuration.getTemplate("report.ftl");
            Writer write = new FileWriter("Report.html");
            template.process(report, write);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}

