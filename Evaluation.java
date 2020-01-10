import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This class enables the client to evaluate his experience in the
 *         medical center as well as his experience of booking an online
 *         appointment.
 */
public class Evaluation {

	static ArrayList<String> questions = new ArrayList<String>();// list of questions for first method
	protected static int[][] sumscenter = new int[4][2];
	private static int ans, i;
	static ArrayList<String> questions2 = new ArrayList<String>();// list of questions for second method
	protected static int[][] sumsapp = new int[3][2];
	private static String ans2;
	static JFrame fr;

	/**
	 * This method adds the questions the client should answer in the corresponding
	 * lists.
	 */
	public static void loadEvaluation() {
		questions.add("--> Evaluate your experience during your stay at the Medical Center.");
		questions.add("--> Evaluate the speed of your service.");
		questions.add("--> Evaluate the quality of your service.");
		questions.add("--> How satisfied are you from interacting with our staff?;");
		questions2.add("--> I found easily the examination I was looking for.");
		questions2.add("--> I usually book my appointment through your website.");
		questions2.add("--> I prefer booking my appointments online.");
	}

	/**
	 * This method asks from the client to evaluate his experience in the medical
	 * center. His answers must be between 1 and 5. They are ,also , being added up
	 * for statistical reasons.
	 */
	public static void evaluate() { // evaluate the center

		JOptionPane.showMessageDialog(fr, "Answer 1-5 (1:very bad 5:very good). \n");
		boolean continueLoop = false;
		i = 0;

		for (String q : questions) {
			do {
				try {

					/*
					 * System.out.println(q); ans = Main.in.nextInt();
					 */
					String an = JOptionPane.showInputDialog(fr, q);
					ans = Integer.parseInt(an);
					if (ans >= 1 && ans <= 5) {
						sumscenter[i][0] += ans;
						sumscenter[i][1]++;
						continueLoop = true; // keeps on to the next question

					} else {
						System.err.println("*** Insert a number from 1 to 5! ***");
						continueLoop = false;
					}
					i++;
				} catch (InputMismatchException i) {
					JOptionPane.showMessageDialog(null, "Please insert an integer 1-5.", "Error message",
							JOptionPane.ERROR_MESSAGE);
					Main.in.nextLine();
				}
			} while (!continueLoop);
		}
		/*
		 * System.out.println("\n \nΗ αξιολόγηση σας καταχωρήθηκε. Σας ευχαριστούμε!");
		 * System.out.println("\n ------------------------------------ \n");
		 */
		JOptionPane.showMessageDialog(fr, "Your answers have been saved. Thank you!");
	}

	/**
	 * This method asks from the client to evaluate his experience of booking an
	 * online appointment. He must answer with YES or NO. His answers are being
	 * added up for statistical reasons.
	 */
	public static void evaluateProcedure() { // evaluate the appointment

		boolean continueLoop = false;

		for (int q = 0; q < questions2.size(); q++) {
			continueLoop = false;
			do {
				try {
					if (q == 0) {

						ans2 = "";
						/*
						 * System.out.println(questions2.get(q));
						 * System.out.println("Απαντήστε με ΝΑΙ ή ΟΧΙ"); Main.in.nextLine(); ans2 =
						 * Main.in.nextLine();
						 */

						ans2 = JOptionPane.showInputDialog(fr, questions2.get(q) + "\r\n Answer with YES or NO.");

						if (ans2.equals(null)) {
							break;
						} else {
							if (ans2.toLowerCase().indexOf("ν") != -1) {
								sumsapp[q][0]++; // sum of "YES" for question q
							} else {
								sumsapp[q][1]++; // sum of "NO" for question q
							}
						}
						continueLoop = true;

					} else {

						/*
						 * System.out.println(questions2.get(q));
						 * System.out.println("Απαντήστε με ΝΑΙ ή ΟΧΙ"); ans2 = Main.in.nextLine();
						 */
						ans2 = JOptionPane.showInputDialog(fr, questions2.get(q) + "\r\n Answer with YES or NO.");

						if (ans2.equals(null)) {
							break;
						} else {
							if (ans2.toLowerCase().indexOf("ν") != -1) {
								sumsapp[q][0]++; // sum of "YES" for question q
							} else {
								sumsapp[q][1]++; // sum of "NO" for question q
							}
						}
						continueLoop = true;
					}
				} catch (InputMismatchException i) {
					JOptionPane.showMessageDialog(null, "Please insert YES/NO.", "Error message",
							JOptionPane.ERROR_MESSAGE);
					Main.in.nextLine();
				}
			} while (!continueLoop);
		}
	}

}
