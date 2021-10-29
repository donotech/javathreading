package com.bdec.hero.training.java;

import java.sql.*;

@SuppressWarnings({"WeakerAccess", "Unused"})
public class MovieDb {
    static String url = "jdbc:sqlserver://aviziva.cqe9nls0ck5k.ap-south-1.rds.amazonaws.com:1433;database=avz_trainer;loginTimeout=30;";
    static String user = "azadmin";
    static String password = "Generic1234";

    public static void insertMovieRaw() {
        String sql = "insert into movie(movie_id, movie_name,year_of_release,genre) values(";
        sql = sql + "141, 'SomeMove', '2015-06-12', 'Action|Epic'" + ")";
        System.out.println(sql);

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user, password);
            Statement statement = connection.createStatement();
            int numRecords = statement.executeUpdate(sql);
            System.out.println("num records = " + numRecords);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static void showAllMovies() {
        String sql = "select * from movie";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Integer movie_id = resultSet.getInt("movie_id");
                String movie_name = resultSet.getString("movie_name");
                Date year_of_release = resultSet.getDate("year_of_release");
                String genre = resultSet.getString("genre");
                System.out.println("Record: " + movie_id + ":" + movie_name + ":" + year_of_release + ":" + genre);
            }

            System.out.println("Done");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static void showAllActors() {
        String sql = "select * from actor";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Integer actor_id = resultSet.getInt("actor_id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                System.out.println("Record: " + actor_id + ":" + name + ":" + gender);
            }

            System.out.println("Done");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    static void checkConnection() {
        Connection connection = null;

        {
            try {
                connection = DriverManager.getConnection(url,user, password);
                System.out.println(connection.getCatalog());

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    static String hackableSQL(String name) {
        String sql = "update name = " + name + " where id = 1000;";
        return sql;
    }

    static void insertMoviePreparedStatement() {
        String withoutPreparedSQL = "insert into movie(movie_id, movie_name,year_of_release,genre) " +
                "values(141, 'SomeMove', '2015-06-12', 'Action|Epic')";

        hackableSQL("devraj" ); //update name = devraj where id = 1000 - will change the db to update name  where id = 1000
        hackableSQL("devraj --"); //update name = devraj -- where id = 1000 - will change all names in the table to devraj
        hackableSQL("root, password = '123' ---"); // so you are toast!

        String sql = "insert into movie(movie_id, movie_name,year_of_release,genre) values(?,?,?,?);";
        System.out.println(sql);

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 132);
            statement.setString(2, "Bahubali2");
            statement.setDate(3, Date.valueOf("2017-07-16"));
            statement.setString(4, "Epic|Action");
            int numRecords = statement.executeUpdate();
            System.out.println("num records = " + numRecords);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static void transaction_demo() {
        String sqlMovie = "insert into movie(movie_id, movie_name,year_of_release,genre) values(?,?,?,?);";
        String sqlActor = "insert into actor(actor_id, name, gender) values (?,?,?);";
        String sqlMovieActor = "insert into movie_actor(movie_id, actor_id, movie_part) values (?,?,?);";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user, password);
            connection.setAutoCommit(false);

            PreparedStatement movieStatement = connection.prepareStatement(sqlMovie);
            movieStatement.setInt(1, 132);
            movieStatement.setString(2, "Bahubali2");
            movieStatement.setDate(3, Date.valueOf("2017-07-16"));
            movieStatement.setString(4, "Epic|Action");
            int numRecords = movieStatement.executeUpdate();

            PreparedStatement actorStatement = connection.prepareStatement(sqlActor);
            actorStatement.setInt(1,131);
            actorStatement.setString(2, "Prabhas");
            actorStatement.setString(3, "Male");
            int actorRecords = actorStatement.executeUpdate();

            PreparedStatement movieActorStatement = connection.prepareStatement(sqlMovieActor);
            movieActorStatement.setInt(1,131);
            movieActorStatement.setInt(2, 131);
            movieActorStatement.setString(3, "Hero");
            int movieActorRecords = movieActorStatement.executeUpdate();

            connection.commit();

            System.out.println("num records = " + numRecords + ":" + actorRecords + ":" + movieActorRecords);

        } catch (SQLException e) {
            e.printStackTrace();
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        checkConnection();


        /****
        //uncomment for db functions

        insertMoviePreparedStatement();
        transaction_demo();
        showAllMovies();
        showAllActors();
        insertMovieRaw();
        showAllMovies();
        // end uncomment
        ****/

    }


}
