package com.epam.test.cource;

import java.sql.*;
import java.util.Properties;

public class DBUtils {

    public Connection getConnection() {

        String databaseURL = "jdbc:h2:mem:test_db;MODE=MYSQL;DB_CLOSE_DELAY=-1";
        Connection conn = null;
        try {
            Properties props = new Properties();
            props.put("user", "sa");
            props.put("password", "");

            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(databaseURL, props);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("An error occurred. ClassNotFoundException: %s", e.getMessage()));
            e.printStackTrace();
        }

        return conn;
    }

    public void createDatabase(Connection connection) throws SQLException {

        System.out.println("--------- create table ------------");
        String createTableQuery =
                " CREATE TABLE app_user ( " +
                        " user_id INT NOT NULL AUTO_INCREMENT," +
                        " login VARCHAR(255) NOT NULL," +
                        " password VARCHAR(255) NOT NULL," +
                        " description VARCHAR(255) NULL," +
                        " PRIMARY KEY (user_id));    ";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println(String.format("Table %s is created.", "app_user"));
        }
    }

    public void addUser(Connection connection, String login, String password, String description) throws SQLException {

        System.out.println("--------- add user ------------");
        String addRecord = "INSERT INTO app_user (login, password, description) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(addRecord)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, description);
            preparedStatement.executeUpdate();
            System.out.println(String.format("User %s is created.", login));
        }
    }

    public void getUsers(Connection connection) throws SQLException {

        System.out.println("--------- get all users ------------");
        String getRecords = "SELECT user_id, login, password, description FROM app_user ORDER BY 2";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getRecords);
            while (resultSet.next()) {
                System.out.println(String.format("User: %s, %s, %s, %s",
                        resultSet.getInt("user_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("description")));
            }
        }

    }

}
