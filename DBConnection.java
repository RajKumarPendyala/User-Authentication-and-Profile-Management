package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con = null;
	public DBConnection() {}
	static {
		try {
			Class.forName(DBInfo.driver);
			con = DriverManager.getConnection(DBInfo.dbUrl, DBInfo.uName, DBInfo.pword);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}
}