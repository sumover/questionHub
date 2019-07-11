package main.Module;

import java.util.Date;

public class Student extends User {
    public Student(Date registerDate, String name, String password) {
        super(registerDate, name, password, USER_TYPE.student);
    }
    public Student(){}
}
