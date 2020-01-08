import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEvaluation {

	@Test
	void testEvaluate() {
		Evaluation.questions.add("--> ������������ ��� �������� ��� ���� ��� �������� ��� ��� ������.");
		Evaluation.questions.add("--> ������������ ��� �������� ������������ ���.");
		Evaluation.questions.add("--> ������������ ��� �������� ������������ ���.");
		Evaluation.questions.add("--> ���� �������������� ������� ��� ��� ������������� �� �� ��������� ���;");
		int[][] expected = { {3, 1}, {4, 1}, {1, 1}, {4, 1} } ;
		/*for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 2; j++) {
				Evaluation.sums[i][j] = 0;
			}
		} */
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
		Evaluation.questions2.add("--> ���� �������������� ������� ��� ��� ������������� �� �� ��������� ���;");
		Evaluation.questions2.add("--> �������� ������ ��� �������� ��� ������.");
		Evaluation.questions2.add("--> ������ ����� �������� ���� ��� �����������.");
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
