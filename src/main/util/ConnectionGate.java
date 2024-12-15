package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionGate {
    private static final String URL = PropertiesUtil.get("db.url");
    private static final String NAME = PropertiesUtil.get("db.name");
    private static final String PASSWORD = PropertiesUtil.get("db.password");


    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection get () {
        try {
            return DriverManager.getConnection(URL,NAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
}
