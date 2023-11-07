package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (var session = Util.hibernateSession()) {
            UserServiceImpl dao = new UserServiceImpl();

//            dao.createUsersTable();
//
//            dao.saveUser("Dmitry", "Knysh", (byte) 32);
//            dao.saveUser("Vladimir", "Pupkin", (byte) 19);
//            dao.saveUser("Denis", "Petrov", (byte) 42);
//            dao.saveUser("Nikolay", "Ivanov", (byte)27);

//            System.out.println(dao.getAllUsers());
//            for (User user : dao.getAllUsers()) {
//                System.out.println(user.getId() + " " + user);
//            }

//            dao.cleanUsersTable();
//
//            dao.dropUsersTable();
        }
        // реализуйте алгоритм здесь
    }
}
