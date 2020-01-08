import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEvaluation {

	@Test
	void testEvaluate() {
		Evaluation.questions.add("--> Evaluate your experience being in our center");
		Evaluation.questions.add("--> How fast were you served?");
		Evaluation.questions.add("--> Evaluate the quality of our services");
		Evaluation.questions.add("--> Which was the level of satisfaction you get after your interraction with our staff?");
		int[][] expected = { {3, 1}, {4, 1}, {1, 1}, {4, 1} } ;
		Evaluation.evaluate();
		int k = 0, l = 0;
		for (int i = 0; i < 4; i++) {
			l = 0;
			k++;
			for (int j = 0; j < 2; j++) {
					assertEquals(expected[i][j], Evaluation.sumscenter[k][l]);
					l++;
			}

		}
	}


	@Test
	void testEvaluateProcedure() {
		Evaluation.questions2.add("--> Are you pleased with the procedure of making an appointment?");
		Evaluation.questions2.add("--> Did you manage to find the service you want easily?");
		Evaluation.questions2.add("--> Do you make apointments often enough?");
		int[][] expected = { {1,0}, {1,0}, {0,1} };
		Evaluation.evaluateProcedure();
		int k = 0, l;
		for (int i = 0;i < 3;i++) {
			l = 0;
			for (int j = 0;j < 2;j++) {
				assertEquals(expected[k][l], Evaluation.sumsapp[i][j]);
				System.out.println(Evaluation.sumsapp[i][j]);
				l++;
			}
			k++;
		}
	}





}
