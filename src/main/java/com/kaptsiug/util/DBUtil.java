package com.kaptsiug.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    private static final String PROPERTIES_FILE = "db-config.properties";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            Properties prop = new Properties();
            InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            prop.load(inputStream);
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}