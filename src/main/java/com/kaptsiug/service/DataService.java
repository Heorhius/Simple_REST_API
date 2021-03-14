package com.kaptsiug.service;

import com.google.gson.Gson;
import com.kaptsiug.db.DataProvider;
import com.kaptsiug.exception.IllegalIDException;
import com.kaptsiug.model.User;

import java.sql.SQLException;
import java.util.List;

public class DataService {
    private final DataProvider dataProvider;
    private final Gson gson;

    public DataService() {
        dataProvider = DataProvider.getProvider();
        gson = new Gson();
    }

    public String getAllUsersForResponse() {
        List<User> users = dataProvider.getAllUsers();
        return gson.toJson(users);
    }

    public void addUser(String jSonString) {
        User user = gson.fromJson(jSonString, User.class);
        dataProvider.addUser(user);
    }

    public void deleteUser(String id) throws IllegalIDException, SQLException {
        char[] chars = id.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                throw new IllegalIDException();
            }
        }
        int userID = Integer.parseInt(id);
        dataProvider.deleteUserByID(userID);

    }
}
