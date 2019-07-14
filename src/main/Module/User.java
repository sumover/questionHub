package main.Module;

import java.util.Date;

enum USER_TYPE {
    teacher, student
}

public abstract class User {
    private int id;
    private Date registerDate;
    private String name;
    private String password;
    private USER_TYPE userType;
    private static int USER_NUM = 0;

    public User(Date registerDate, String name, String password, USER_TYPE type) {
        this.registerDate = registerDate;
        this.name = name;
        this.password = password;
        this.userType = type;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
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
