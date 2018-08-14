package conn;

import java.sql.Connection;
import java.sql.SQLException;
 
public class ConnectionUtils {
 
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
         return MySQLConnection.getMySQLConnection();
    }
     
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
 
    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}