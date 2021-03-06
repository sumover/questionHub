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
        ResultSet userSet = connector.selectValues(
                "select * from user_data where name=? and password=?;",
                new String[]{name, password}
        );
        return getUser(userSet);
    }

    User getUser(int uid) {
        ResultSet userSet = connector.selectValues(
                "select * from user_data where id=?;",
                new String[]{Integer.toString(uid)}
        );
        return getUser(userSet);
    }

    private static User getUser(ResultSet userSet) {
        User user = null;
        try {
            if (userSet.next()) {
                String type = userSet.getString(5);
                if (type.equals("teacher")) {
                    user = new Teacher();
                } else if (type.equals("student")) {
                    user = new Student();
                }
                assert user != null;
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

