package com.lab8;



import com.lab8.dao.GenreDAOImpl;
import com.lab8.dao.MovieDAOImpl;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

//       new AddInformationsToTable();
        System.out.println(new MovieDAOImpl().get(0));
        System.out.println(new GenreDAOImpl().get(0));



    }
}
