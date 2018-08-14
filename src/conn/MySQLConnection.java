package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class MySQLConnection {
  
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "mytasklist";
		String userName = "root";
		String password = "root";
		
		return getMySQLConnection(hostName, dbName, userName, password);
	}
  
	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) 
			throws SQLException, ClassNotFoundException {
    
		Class.forName("com.mysql.cj.jdbc.Driver");
		String useSSL = "?useSSL=false";
		String timezone = "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + useSSL + timezone;
  
  		Connection conn = DriverManager.getConnection(connectionURL, userName, password);

  		return conn;
     }
}