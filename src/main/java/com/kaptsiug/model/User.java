package com.kaptsiug.model;

public class User {
    private int id;
    private String firstName;
    private String login;
    private String password;
    private int age;

    public User(int id, String firstName, String login, String password, int age) {
        this.id = id;
        this.firstName = firstName;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public User(String firstName, String login, String password, int age) {
        this.firstName = firstName;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
