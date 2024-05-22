package listenerImplements;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.baseClassutility.BaseClass;

public class SampleInvocationTest  {

	@Test(retryAnalyzer = com.vtiger.listenerutility.RetryListenerImplementation.class)
	public void activateTest() {
		System.out.println("CreateInvoiceTest is executed");
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println("Step-5");
	}

}
