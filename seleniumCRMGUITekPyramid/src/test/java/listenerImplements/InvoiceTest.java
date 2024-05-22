package listenerImplements;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.baseClassutility.BaseClass;

public class InvoiceTest extends BaseClass {
	
	@Test
	public void createInvocationTest() {
		System.out.println("createInvocationTest is executing");
		String acttitle = driver.getTitle();
		Assert.assertEquals(acttitle, "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
	}
	
	@Test
	public void createContactWithInvocationCount() {
		System.out.println("createContactWithInvocationCount is executing");
		System.out.println("Step-1");
		System.out.println("Step-2");
	}

}
