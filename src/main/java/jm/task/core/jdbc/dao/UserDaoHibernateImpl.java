package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {

    }


    @Override
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

        try (var session = Util.hibernateSession()) {
            session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
        }


    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";

        try (var session = Util.hibernateSession()) {
            session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (var session = Util.hibernateSession()) {
            User user = new User(name, lastName, age);
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
            System.out.println("User с именем " + name + " " + lastName + " добавлен в базу данных");
        }

    }

    @Override
    public void removeUserById(long id) {
        try (var session = Util.hibernateSession()) {
            session.beginTransaction();

            session.delete(session.get(User.class, id));

            session.getTransaction().commit();
            System.out.println("User с id " + id + " удалён из базы данных");
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (var session = Util.hibernateSession()) {
            session.beginTransaction();

            users = session.createQuery("from User").getResultList();

            session.getTransaction().commit();
        }

        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (var session = Util.hibernateSession()) {
            session.beginTransaction();

            session.createQuery("delete from User").executeUpdate();

            session.getTransaction().commit();
        }
    }
}
