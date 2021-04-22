package com.lab8;


import com.lab8.objects.MovieReport;
import com.lab8.tools.Report;
import jxl.read.biff.BiffException;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, BiffException {


//        new AddInformationsToTable();
//        new ImportFromDataset("E:\\Downloads\\dataset\\moviesImdb.csv");
//        new MovieInformation(1).printInformation();
        BasicConfigurator.configure();
         new Report(1).Run();

        System.out.println(new MovieReport(0));


    }
}
