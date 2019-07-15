package main.SQLConnctor;


import java.sql.*;
import java.util.*;

public class Connector {
    private final static String url;
    private final static String IPV4;
    private final static String databaseName;
    private final static String port;
    private final static String password;
    private final static String username;
    private static Connector _connector = new Connector();
    private static boolean connected = false;

    static {
        IPV4 = "localhost";
        username = "root";
        password = "2323180";
        databaseName = "web_note_databases";
        port = "3306";
        url = "jdbc:mysql://" + IPV4 + ":" + port + "/" + databaseName + "?serverTimezone=UTC";
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public synchronized static boolean isConnected() {
        return connected;
    }

    private Connection connection;
    private Statement statement;

    private Connector() {
    }

    public synchronized static void connect_static() {
        _connector.connect();
    }

    public synchronized static void disconnect_static() {
        _connector.disConnect();
    }

    public void connect() {
        connected = true;
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
        connected = false;
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

    public Connection getConnection() {
        return connection;
    }

    /**
     * @param sql        要注入的sql语句
     * @param parameters 被注入sql语句的参数
     * @return 这个很有意思, 这个的返回值是表中刚插入的语句的自增量的值
     */
    public int insertValues(String sql, String[] parameters) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (parameters != null) for (int i = 0; i < parameters.length; ++i)
                statement.setString(i + 1, parameters[i]);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * @param sql        被注入的sql语句
     * @param parameters 注入sql语句的参数
     * @return ResultSet
     */
    public ResultSet selectValues(String sql, String[] parameters) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            if (parameters != null) for (int i = 0; i < parameters.length; ++i)
                statement.setString(i + 1, parameters[i]);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 用来获取某个table的所有的id列表
     *
     * @param table 表名
     * @return
     */
    public Integer[] getIdArrays(String table) {
        List<Integer> list = new LinkedList<Integer>();
        try {
            String sql = "select id from " + table + " ;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) list.add(set.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.toArray(new Integer[list.size()]);
    }

    /**
     * @param sql        要被注入的sql语句
     * @param parameters 被注入的parameter
     * @return 删除的数量
     */
    public int deleteValues(String sql, String[] parameters) {
        int deleteNum = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            if (parameters != null) for (int i = 0; i < parameters.length; ++i)
                statement.setString(i + 1, parameters[i]);
            deleteNum = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteNum;
    }

    /**
     * 单例模式, 此处使用静态全局变量,反正代码也不是很长...
     *
     * @return
     */
    public static synchronized Connector getInstance() {
        return _connector;
    }

}
