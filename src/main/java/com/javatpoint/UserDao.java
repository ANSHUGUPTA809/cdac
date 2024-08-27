package com.javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/login?useSSL=true&verifyServerCertificate=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";
    
    private static final String INSERT_USER_SQL = "INSERT INTO login_Table (name, email) VALUES (?, ?)";
    private static final String SELECT_ALL_USERS = "SELECT * FROM login_Table";

    // Default constructor
    public UserDao() {}

    // Overloaded constructor to allow custom JDBC configuration
    public UserDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                // Add a new user object with the fetched data
           //   users.add(new User());
                users.add(new User(name, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
