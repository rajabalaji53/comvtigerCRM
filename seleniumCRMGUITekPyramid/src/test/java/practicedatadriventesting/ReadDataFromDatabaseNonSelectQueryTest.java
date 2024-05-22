package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabaseNonSelectQueryTest {

	public static void main(String[] args) throws Throwable {

		// Step 1: load/register the database driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		// Step 2: Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		// Step 3: create sql statement
		Statement stat = conn.createStatement();
		
		// Step 4: Execute non select query
		int result = stat.executeUpdate("insert into project values('Arunn','kumar',33,'male');");
		System.out.println(result);
		
		// Step 5: close the connection
		conn.close();
	}

}
