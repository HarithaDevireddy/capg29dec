import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ReadDemo {
	private static Logger logger = Logger.getLogger(ReadDemo.class);

	public static void main(String[] args) throws Exception {

		// 1. Collect the DB information
		String driverClassName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/employeedb";
		String user = "postgres";
		String password = "admin";
		// 2. Register the Driver
		Class c = Class.forName(driverClassName);
		// System.out.println(c);
		logger.info(c);
		// 3. Get Connection Object
		Connection con = DriverManager.getConnection(url, user, password);
		logger.info(con);
		// 4. Create Statement and execute query
		String sql = "SELECT * FROM employees";
		Statement stmt =  con.createStatement();
		logger.info(stmt);
		logger.info(sql);
		ResultSet rs =  stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			int age = rs.getInt("age");
			System.out.println("-------------->"+id+ "--"+fname+"--"+lname+"--"+age);
		}
		
		// 5. Release Resource (Statement, Connection)
		stmt.close();
		con.close();
	}

}
