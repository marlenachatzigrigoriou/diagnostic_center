import org.junit.*;
import polyiatrio.Menu;


public class MenuTest {


	@Test
	public void testchooseService() {

		Services.listEidikotites();
		String result=Menu.chooseService();
		Assert.assertNotNull("result shouldn't be null", result);

	}


	@Test
	public void testchooseCriterion() {

		String result=Menu.chooseCriterion();
		Assert.assertNotNull("result shouldn't be null", result);

	}

	@Test
	public void testfilterAndPrintServices() {

		Services s = new Services("γενική εξέταση αίματος", 4, "αιματολογικές", 5);
	    Services h = new Services("αιματοκρίτης", 75, "αιματολογικές", 1);
		Services.aimatologikes.add(s);
		Services.aimatologikes.add(h);
		Services.eidikotitesoles.add(Services.aimatologikes);

		boolean result = Menu.filterAndPrintServices("αιμ","αιματολογικές");


		Assert.assertTrue("result should be true", result);


	}

}
