package polyiatrio;

import java.util.ArrayList;
import polyiatrio.Employees;
//import org.junit.Before;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;


public class TestEmployee {
	
	
	
	private ArrayList <Employees>employees =new ArrayList<Employees>() ;
	private Employees e1 = new Employees("Mark Smith", "aimatologikes");
	private Employees e2 = new Employees("Tom Adams", "checkup");
	static ArrayList<Employees> giatroi_aimatologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_checkup = new ArrayList<Employees>();

	
	public void listsBySpecialty() {
		
		for (int i=0;i<= employees.size()-1;i++) {
			
			if (employees.get(i).getSpecialty().equals("aimatologikes")) {
				
				giatroi_aimatologikes.add(employees.get(i));
			}
			
			if (employees.get(i).getSpecialty().equals("checkup")) {
				
				giatroi_checkup.add(employees.get(i));
			}
		}

	}
	
	@Test
	public void testAdd() {
		
		employees.add(e1);
		employees.add(e2);
		
		Assert.assertTrue("list doesn't contain first object",employees.contains(e1));
		Assert.assertTrue("list doesn't contain second object",employees.contains(e2));		
	}
	
	
	@Test
	public void separateLists() {
		
		employees.add(e1);
		employees.add(e2);
		listsBySpecialty();
		
		Assert.assertTrue("false separation!",giatroi_aimatologikes.contains(e1));
		Assert.assertTrue("false separation!",giatroi_checkup.contains(e2));
		Assert.assertFalse("separation failed",giatroi_aimatologikes == null || giatroi_aimatologikes.contains(e2));
		Assert.assertFalse("separation failed",giatroi_checkup == null || giatroi_checkup.contains(e1));

	
	}
	
	
	
	@After
	public void tearDown(){
		
		employees = null;
	}






}
