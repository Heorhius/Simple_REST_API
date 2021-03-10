package com.kaptsiug.db;

import com.kaptsiug.model.User;
import com.kaptsiug.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static final String MSG_USER_NOT_FOUND = "No entity with id: %d";
    private static final String QUERY_SELECT_ALL_USERS = "SELECT * FROM User;";
    public static final String QUERY_INSERT_USER = "INSERT INTO User (firstName,login,password,age) VALUES (?,?,?,?);";
    public static final String QUERY_DELETE_USER_BY_ID = "DELETE FROM User WHERE User.id = ?";
    private static DataProvider provider;

    private DataProvider() {
    }

    public static DataProvider getProvider() {
        if (provider == null) {
            provider = new DataProvider();
        }
        return provider;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(QUERY_SELECT_ALL_USERS);) {
            while (rs.next()) {
                User user = new User(rs.getInt("id")
                        , rs.getString("firstName")
                        , rs.getString("login")
                        , rs.getString("password")
                        , rs.getInt("age"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(QUERY_INSERT_USER);) {
            pStatement.setString(1, user.getFirstName());
            pStatement.setString(2, user.getLogin());
            pStatement.setString(3, user.getPassword());
            pStatement.setInt(4, user.getAge());
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUserByID(int id) throws Exception {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(QUERY_DELETE_USER_BY_ID);) {
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
