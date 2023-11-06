package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (var session = Util.hibernateSession()){
//            UserDaoJDBCImpl dao = new UserDaoJDBCImpl();
            UserDaoHibernateImpl dao = new UserDaoHibernateImpl();

//            dao.createUsersTable();
            dao.removeUserById(1);
//            dao.saveUser("Dmitry", "Knysh", (byte) 32);
//            dao.saveUser("Vladimir", "Pupkin", (byte) 19);
//            dao.saveUser("Denis", "Petrov", (byte) 42);

//            dao.createUsersTable();
//            dao.saveUser("Nikolay", "Ivanov", (byte)27);
//            dao.saveUser("Dmitry", "Knysh", (byte)32);
//            dao.saveUser("Vladimir", "Pupkin", (byte)19);
//            dao.saveUser("Denis", "Petrov", (byte)42);
//            System.out.println(dao.getAllUsers());
//            dao.cleanUsersTable();
//            dao.dropUsersTable();
        }
        // реализуйте алгоритм здесь
    }
}
