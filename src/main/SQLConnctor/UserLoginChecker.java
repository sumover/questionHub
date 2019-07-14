package main.SQLConnctor;

import main.Module.Student;
import main.Module.Teacher;
import main.Module.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginChecker {
    private Connector connector;

    public UserLoginChecker() {
        connector = Connector.getInstance();
    }

    public User loginCheck(String name, String password) {
        User user = null;
        ResultSet userSet = connector.selectValues(
                "select * from user_data where name=? and password=?;",
                new String[]{name, password}
        );
        try {
            if (userSet.next()) {
                String type = userSet.getString(5);
                if (type.equals("teacher")) {
                    user = new Teacher();
                } else if (type.equals("student")) {
                    user = new Student();
                }
                user.setId(userSet.getInt(1));
                user.setName(userSet.getString(2));
                user.setPassword(userSet.getString(3));
                user.setRegisterDate(userSet.getDate(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

