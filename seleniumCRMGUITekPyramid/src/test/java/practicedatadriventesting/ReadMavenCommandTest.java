package practicedatadriventesting;

import org.testng.annotations.Test;

public class ReadMavenCommandTest {
	@Test
	public void mavencommandtest() {
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println("Env Data==>URL==>"+URL);
		System.out.println("Env Data==>BROWSER==>"+BROWSER);
		System.out.println("Env Data==>USERNAME==>"+USERNAME);
		System.out.println("Env Data==>PASSWORD==>"+PASSWORD);

	}

}
