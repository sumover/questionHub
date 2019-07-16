package main.SQLConnctor;


import java.sql.*;
import java.util.*;

/**
 * 核心数据库查询组件
 * Licensed to GPL
 * 请手动设置数据库IPV4地址, 端口, 数据库名, 密码, 用户名的属性
 */
public class Connector {
    private final static String url;
    private final static String IPV4;
    private final static String databaseName;
    private final static String port;
    private final static String password;
    private final static String username;
    private static Connector _connector = new Connector();
    private static boolean connected = false;


    // 初始化
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

    private Connection connection;

    private Statement statement;

    private Connector() {
    }

    /**
     * 原子操作, 要求必须线程安全
     * 不过就是查个boolean的值, 应该很快
     *
     * @return connected or not
     */
    public synchronized static boolean isConnected() {
        return connected;
    }

    /**
     * 静态全局变量 _connector 的一个连接方法, 要求在每个Servlet类加载时判断是否加载并调用该方法
     */
    public synchronized static void connect_static() {
        _connector.connect();
    }

    /**
     * 同上
     */
    public synchronized static void disconnect_static() {
        _connector.disConnect();
    }

    private void connect() {
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

    private void disConnect() {
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
     * 用来获取某个table的所有的id列表, 具有可扩展的条件参数,没有扩展的参数时请设为null
     *
     * @param table      表名
     * @param conditions 条件 请默认设为null
     * @return
     */
    public Integer[] getIdArrays(String table, String conditions) {
        List<Integer> list = new LinkedList<Integer>();
        try {
            String sql = "select id from " + table + ((conditions == null) ? " ;" : " " + conditions + " ;");
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
