package com.epam.test.cource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException {

        System.out.println("Hello World!");

        DBUtils dbUtils = new DBUtils();
        Connection connection = null;

        try {
            connection = dbUtils.getConnection();

            dbUtils.createDatabase(connection);

            dbUtils.addUser(connection,"admin", "admin", "admin user");
            dbUtils.addUser(connection,"user1", "user1", "usually user1");
            dbUtils.addUser(connection,"user2", "user2", "usually user2");

            dbUtils.getUsers(connection);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
