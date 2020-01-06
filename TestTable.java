package polyiatrio;

import org.junit.Assert;
import org.junit.Test;

public class TableTest {

	
	String t[][] = new String[17][Employees.employees.size() + 2]; 
	Table table=new Table();
	
	@Test
	public void testcheckingFreehours() {
	
		String[][] result= table.checkingFreehours(t,"αιματολογικές",40);
		Assert.assertNotSame("result shouldn't be zero.", 0, result);
		
		
	}
	
	
	
	@Test
	public void testcheckingFreehoursDOC() {
	
		int result= table.checkingFreehours(t, "αιματολογικές", 30, 2);
		Assert.assertNotSame("result shouldn't be null",null,result);
		
	}
	
	
	
	
	
}
