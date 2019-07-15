package main.Module;

import java.util.Date;

public class Student extends User {
    public Student(Date registerDate, String name, String password) {
        super(registerDate, name, password, "student");
    }

    public Student() {
        super();
        super.setUserType("student");
    }
}
