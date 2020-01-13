import org.junit.Test;

import junit.framework.Assert;

public class EnterAppointmentTest {

	double[] result=new double[2] ;
	String []t = {"","αιματολογικές","αιματοκρίτης"};



	@Test
	public void choiceDurationTest() {

		result = EnterAppointment.choiceDuration(t);
		Assert.assertNotSame("result shouldn't be zero.", result, 0);

	}

	@Test
	public void questionsToBeginTest() {
		Services.listEidikotites();
		t= EnterAppointment.questionsToBegin();


		Assert.assertNotNull("array shouldn't be null", t);

	}

}
