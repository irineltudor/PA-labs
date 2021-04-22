package com.lab8.dao;

import com.lab8.connection.connectToDB;
import com.lab8.objects.Actor;
import com.lab8.interfaces.ActorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ActorDAOImpl implements ActorDAO{
    int id=0;
    static Connection conn
            = connectToDB.getConnection();
    @Override
    public void add(Actor actor) throws SQLException {
        String query
                = "insert into movie_actors VALUES (?, ?, ?)";
        PreparedStatement ps
                = conn.prepareStatement(query);
        ps.setInt(1,id);
        id++;
        ps.setString(2, actor.getName());
        ps.setInt(3,actor.getMovieId());
        ps.executeUpdate();

    }

    @Override
    public void delete(int id){

    }

    @Override
    public Actor getActor(int id) throws SQLException {



        String query
                = "select * from movie_actors where id= ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setInt(1, id);
        Actor actor= new Actor();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            actor.setName(rs.getString("name"));
            actor.setMovieId(rs.getInt("movieId"));


        }

        if (check) {
            return actor;
        }
        else
            return null;
    }

    @Override
    public List<Actor> get(int movieId) throws SQLException {

        List<Actor> actorsList = new LinkedList<>();

        String query
                = "select * from movie_actors where movieId= ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setInt(1, movieId);
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;

            Actor actor= new Actor();
            actor.setName(rs.getString("name"));
            actor.setMovieId(rs.getInt("movieId"));
            actorsList.add(actor);
        }

        if (check) {
            return actorsList;
        }
        else
            return null;
    }

    @Override
    public void update(int id){

    }
}
