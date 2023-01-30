package database;

import jdk.internal.icu.text.UnicodeSet;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {
    private Connection connection;
    private final String databaseName = "database";
    private final String tableName = "users";
    private final String user = "root";
    private final String password = "czarybka";

    public UserDao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new LinkedList<User>();
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                Integer age = resultSet.getInt("age");
                User user = new User(name, lastname, age);
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }
}