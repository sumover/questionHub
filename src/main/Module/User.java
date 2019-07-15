package main.Module;

import java.util.Date;


public abstract class User {
    private int id;
    private Date registerDate;
    private String name;
    private String password;
    private String userType;
    private static int USER_NUM = 0;

    public User(Date registerDate, String name, String password, String type) {
        this.registerDate = registerDate;
        this.name = name;
        this.password = password;
        this.userType = type;
    }

    public String  getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
