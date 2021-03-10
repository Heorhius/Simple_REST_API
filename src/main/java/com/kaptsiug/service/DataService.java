package com.kaptsiug.service;

import com.google.gson.Gson;
import com.kaptsiug.db.DataProvider;
import com.kaptsiug.exception.IllegalIDException;
import com.kaptsiug.model.User;

import java.util.List;

public class DataService {
    public static final String MSG_ID_ILLEGAL_INPUT = "Illegal input of User ID";
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

    public void deleteUser(String id) throws IllegalIDException {
        char[] chars = id.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                throw new IllegalIDException(MSG_ID_ILLEGAL_INPUT);
            }
        }
        int userID = Integer.parseInt(id);
        try {
            dataProvider.deleteUserByID(userID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
