package practicedatadriventesting;

import org.testng.annotations.Test;

public class ToWorkOnHelperAttributes {
	
	@Test(invocationCount = 2, threadPoolSize = 2)
	public void createContact() {
		System.out.println("Create Contact is executing");
	}
	
	@Test (invocationCount = 1, threadPoolSize = 3)
	public void deleteContact() {
		System.out.println("Deleting contact is done successfully");
	}
	
	@Test (invocationCount = 4, threadPoolSize = 1)
	public void modifyContact() {
		System.out.println("Modifying contact is done successfully");
	}

}
