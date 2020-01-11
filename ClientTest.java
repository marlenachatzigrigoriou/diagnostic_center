import org.junit.Test;

import junit.framework.Assert;

public class ClientTest {

	Client c1 = new Client("aa","sss","2222");
	Client c2 = new Client("assa","acss","234322");
	
	@Test
	public void QuestionsAboutClientTest() {
		
		Client.questionsAboutClient();
		
		Client.addClient(c1);
		Client.addClient(c2);
		Assert.assertNotNull("array c shouldn't be null", Client.clients);
		
	}
		
}
