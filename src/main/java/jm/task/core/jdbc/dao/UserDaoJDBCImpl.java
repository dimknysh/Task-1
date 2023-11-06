package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users
                (
                id SERIAL PRIMARY KEY ,
                name VARCHAR(128) NOT NULL ,
                lastName VARCHAR(128) NOT NULL ,
                age SMALLINT NOT NULL
                )
                """;

        try (Connection connection = Util.jdbcOpen();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String sql = """
                DROP TABLE IF EXISTS users;
                """;

        try (Connection connection = Util.jdbcOpen();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = """
                INSERT INTO users (name, lastname, age)
                VALUES (?, ?, ?);
                """;

        try (Connection connection = Util.jdbcOpen();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем " + name + " " + lastName + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {
        String sql = """
                DELETE FROM users
                WHERE id = ?;
                """;

        try (Connection connection = Util.jdbcOpen();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("User с id " + id + " удалён из базы данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String sql = """
                SELECT name, lastname, age
                FROM users;
                """;

        List<User> userList = new ArrayList<>();
        try (Connection connection = Util.jdbcOpen();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                userList.add(new User(name, lastName, age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return userList;
    }

    public void cleanUsersTable() {
        String sql = """
                DELETE 
                FROM users;
                """;

        try (Connection connection = Util.jdbcOpen();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
