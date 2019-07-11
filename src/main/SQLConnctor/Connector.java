package main.SQLConnctor;

import main.Module.Student;

import java.sql.*;

public class Connector {
    private final static String url = "jdbc:mysql://192.168.132.2:3306/seqh_db?serverTimezone=UTC";
    private final static String password = "2323180";
    private final static String username = "sumover";
    private static Connector _connector = new Connector();

    private Connection connection;
    private Statement statement;

    private Connector() {
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("database connect success!");
    }

    public void disConnect() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("bye!");
    }

    public Statement getStatement() {
        return statement;
    }

    public static Connector getInstance() {
        return _connector;
    }

    public static void main(String[] args) {
        Connector connector = getInstance();
        connector.connect();
        addUser addUser = new addUser();
        addUser.add();
        connector.disConnect();
    }
}
