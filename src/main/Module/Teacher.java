package main.Module;

import java.util.Date;

public class Teacher extends User {
    public Teacher(Date registerDate, String name, String password) {
        super(registerDate, name, password, USER_TYPE.teacher);
    }
}
