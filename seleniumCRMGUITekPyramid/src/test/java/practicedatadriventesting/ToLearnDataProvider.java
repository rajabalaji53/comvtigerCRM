package practicedatadriventesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToLearnDataProvider {
	
	@Test(dataProvider = "getData")
	public void createContact(String firstname, String lastname, long phonenumber) {
		System.out.println("firstname :"+ firstname +", lastname :"+ lastname +", phoneNumber :"+ phonenumber);
	}
	
	@DataProvider
	public Object[][]getData(){
		Object[][] obj=new Object[3][3];
		
		obj[0][0]="raja";
		obj[0][1]="balaji";
		obj[0][2]=9865470395l;
		
		obj[1][0]="bharathi";
		obj[1][1]="s";
		obj[1][2]=9865470393l;
		
		obj[2][0]="venkatasubramanian";
		obj[2][1]="S";
		obj[2][2]=9698831376l;
		
		return obj;
	}

}
