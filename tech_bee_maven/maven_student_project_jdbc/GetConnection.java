package maven_student_project_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public Connection get_Connection() {
		Connection conn = null;
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL_DB = "jdbc:mysql://studentdb.c7mpdiq8jke2.us-east-1.rds.amazonaws.com:3306/techbeedb";
		final String USER = "marilynh";
		final String PASS = "passadd123";

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL_DB, USER, PASS);
			System.out.println("Connected to the database");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Driver is not found");
		}
		return conn;
	}

}
