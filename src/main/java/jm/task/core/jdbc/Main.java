package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (var connection = Util.open()){
            UserDaoJDBCImpl dao = new UserDaoJDBCImpl();
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
