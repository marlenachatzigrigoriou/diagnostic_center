import org.junit.Assert;
import org.junit.Test;

public class DeleteandChangeTest {

	Table[][] calendar = new Table[17][Employees.employees.size() + 2];

	String[] info = new String[3];

	@Test
	public void testkeepInfo() {

		info = DeleteAndChange.keepInfo(DeleteAndChange.changeQuestions(), calendar);

		Assert.assertNotNull("array shouldn't be null", info);

	}

	@Test
	public void testkeepInfoDuration() {

		double[] result = DeleteAndChange.keepInfoDuration("αιματολογικές", "αιμοσφαιρίνη");
		Assert.assertNotNull("result shouldn't be null", result);

	}

}
