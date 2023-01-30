package database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user = new User("Jan", "Nowak", 20);
        System.out.println(user);
        UserDao userDao = new UserDao();
        System.out.println(userDao.getAllUsers());

    }
}
