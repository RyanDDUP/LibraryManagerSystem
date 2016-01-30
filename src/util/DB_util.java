package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_util {
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";

	public static final String DBURL = "jdbc:mysql://localhost:3306/db_book?autoReconnect=true&useSSL=true";

	public static final String DBUSER = "root";

	public static final String DBPW = "Zhanry279";
	private Connection conn = null;

	/*
	 * return conneciton
	 */
	public Connection getConn() {

		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.conn;

	}
	
	
}
