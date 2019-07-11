package main.SQLConnctor;

import main.Module.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class addUser {
    Connector connector;

    public addUser() {
        connector = Connector.getInstance();
    }

    void add() {
        Statement statement = connector.getStatement();
        try {
            statement.executeUpdate("insert into user_tb (name, password, property, register_time) values (`gugugu`,`2323180`,`student`,now());");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
