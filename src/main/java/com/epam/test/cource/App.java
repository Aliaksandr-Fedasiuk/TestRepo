package com.epam.test.cource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException {

        System.out.println("Hello World!");

        Human human = new SuperHero();
        human.speak();

        Human humanNew = BioReactor.getHuman("SuperHero"); //рецепт из конфига. основная идея не перекомпилировать код
        Human citezen = BioReactor.getHuman("Citizen");

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Developer developer = (Developer) context.getBean("dev");
        System.out.println(developer.toString());

//        DBUtils dbUtils = new DBUtils();
//        Connection connection = null;
//
//        try {
//            connection = dbUtils.getConnection();
//
//            dbUtils.createDatabase(connection);
//
//            dbUtils.addUser(connection,"admin", "admin", "admin user");
//            dbUtils.addUser(connection,"user1", "user1", "usually user1");
//            dbUtils.addUser(connection,"user2", "user2", "usually user2");
//
//            dbUtils.getUsers(connection);
//
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
    }
}
