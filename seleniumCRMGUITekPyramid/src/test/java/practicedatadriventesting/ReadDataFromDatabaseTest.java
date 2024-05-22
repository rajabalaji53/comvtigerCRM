package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {

		// Step 1: load or register the database driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		// Step 2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		// Step 3: Create sql statements
		Statement stat = conn.createStatement();
		
		// Step 4: Execute select query
		ResultSet resultset = stat.executeQuery("select * from project");
		while(resultset.next()) {
			System.out.println(resultset.getString(1)+ "\t" + resultset.getString(2)+ "\t" + resultset.getString(3)+ "\t" + resultset.getString(4));
		}
		
		// Step 5: close the connection
		conn.close();
	}

}
