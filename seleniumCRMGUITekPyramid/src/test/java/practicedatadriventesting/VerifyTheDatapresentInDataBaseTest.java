package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class VerifyTheDatapresentInDataBaseTest {

	@Test
	public void verifyprojectcheck() throws SQLException {
		
		String expectedFirstName="Raja";
		boolean flag=false;
		
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
					String actdata = resultset.getString(1);
					if(expectedFirstName.equals(actdata)) {
						flag=true;
						System.out.println(expectedFirstName +" is present==> PASS");
					}
				}
				if(flag=false) {
					System.out.println(expectedFirstName +" is not present==> FAIL");
				}
				
				// Step 5: close the connection
				conn.close();
	}
}
