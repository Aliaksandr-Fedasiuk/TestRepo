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

        Developer developer1 = (Developer) context.getBean("dev1");
        developer1.setCoffeConsumer(true);
        System.out.println(developer1.toString());

        Developer developer2 = (Developer) context.getBean("dev2");
        System.out.println(developer2.toString());

        Developer developer3 = (Developer) context.getBean("dev3");
        System.out.println(developer3.toString());

        Developer developer4 = (Developer) context.getBean("dev4");
        System.out.println(developer4.toString());

        Project project = context.getBean("project", Project.class);
        System.out.println(project);

        BioReactor bioReactor = context.getBean("bioReactor", BioReactor.class);
        System.out.println(bioReactor.toString());



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
