import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class MenuTest {
	Menu m = new Menu ();

	@Test
	void testChooseService() {
		String input = "αιματολογικές";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals("αιματολογικές",Menu.chooseService());
	}
		

	@Test
	void testChooseCriterion() {
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals("1",Menu.chooseCriterion());
	}

	@Test
	void testSumPlus() {
		Menu.sum_categories[0]=0;
		Menu.sumPlus("αιματολογικές");
		assertEquals(1,Menu.sum_categories[0]);
	}
	@Test
	void testSumMinus() {
		Menu.sum_categories[0]=1;
		Menu.sumMinus("αιματολογικές");
		assertEquals(0,Menu.sum_categories[0]);
	}

}
