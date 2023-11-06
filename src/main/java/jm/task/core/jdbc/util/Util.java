package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc_hiber_task1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "d8549K3832";

    public Util () {

    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // реализуйте настройку соеденения с БД
}
