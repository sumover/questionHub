package main.SQLConnctor;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestSQLMain {
    public static void main(String[] args) {
        Connector.connect_static();
        Connector connector = Connector.getInstance();
        Connection connection = connector.getConnection();
        Connector.disconnect_static();
    }
}
