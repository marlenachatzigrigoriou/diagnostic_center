import polyiatrio.Employees;
import org.junit.Assert;

import org.junit.After;
import org.junit.Test;


public class TestEmployees {



	Employees e1 = new Employees("Mark Smith", "αιματολογικές");
	Employees e2 = new Employees("Tom Adams", "checkup");



	@Test
	public void testChangeEmployees() {

		Employees.employees.add(e1);
		Employees.employees.add(e2);
		Services.listEidikotites();

		Employees.changeEmployees();


	}

	@After
	public void tearDown(){

		Employees.employees = null;
	}



}
