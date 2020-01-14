import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This is the Main Class. It contains the main method where all the
 *         other classes and methods are being called.
 *
 */

public class Main {

	public static Scanner in = new Scanner(System.in);
	static JFrame fr;

	/**
	 * This method fills in the lists with the services and the employees of the
	 * center by reading them from the .txt files. The appointment table is also
	 * being created.
	 * 
	 * @param calendar = the appointment table
	 * @param path     = the path where the files with the services are
	 */
	public static void loadObjects(Table[][] calendar, String path) { // CREATE Services, Employees,
																		// Calendar(type:Table)
		Services.listEidikotites();
		Services.addAllServices();
		boolean err = true;
		int size = Services.eidikotites.size();

		for (int i = 0; i < size; i++) {
			err = true;
			while (err) {
				try {
					CreateObjects.createServices(path + Services.eidikotites.get(i) + ".txt");
					err = false;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"We found something wrong with the file " + Services.eidikotites.get(i) + " you used!",
							"Error message", JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(null, "Fix it and insert the file again.", "Error message",
							JOptionPane.ERROR_MESSAGE);
					path = JOptionPane.showInputDialog(fr, "");
				}
			}
		}

		err = true;
		while (err) {
			try {
				CreateObjects.createEmployees(path + "employees.txt");
				err = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "There is something wrong with the employees file you used!",
						"Error message", JOptionPane.ERROR_MESSAGE);
			}
		}

		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 30; j++) {
				Table table = new Table();
				calendar[i][j] = table;
			}
		}
	}

	/**
	 * The main method. It communicates with the client and the medical center. The
	 * client can manage an appointment and evaluate the center and the business can
	 * manage its services and employees and also view statistic results about the
	 * demand of their services.
	 */
	public static void main(String[] args) throws Exception {
	
		String clientChoice;
		String identity;
		Table calendar[][] = new Table[13][31];
		int pl = 0;

		String path = JOptionPane.showInputDialog(fr, "Please insert the path" + " where the .txt files are saved.");
		path = path + "\\";
		String clientpath = path.replace("\\", "\\\\");

		loadObjects(calendar, clientpath);
		Evaluation.loadEvaluation();

		for (;;) {
			if (pl > 1) {
				identity = JOptionPane.showInputDialog(fr, "BUSINESS / CLIENT");
			} else {
				identity = JOptionPane.showInputDialog(fr, "BUSINESS / CLIENT");
			}

			if (identity.contains("CLIENT")) {

				clientChoice = JOptionPane.showInputDialog(fr, "(1)Book Appointment" + "\r\n (2)Delete Appointment"
						+ "\r\n (3)Change Appointment" + "\r\n (4)Evaluate Medical Center");

				if (clientChoice.contains("1")) {

					Client.questionsAboutClient();
					String t[] = EnterAppointment.questionsToBegin();
					double dur[] = EnterAppointment.choiceDuration(t);
					String ans = t[0];

					if (ans.equals("1")) {
						EnterAppointment.basedOnDate(t, dur, calendar, "katachorish");
						JOptionPane.showMessageDialog(fr, "Please answer the following questions about our website!");
						Evaluation.evaluateProcedure();

					} else if (ans.equals("2")) {
						EnterAppointment.basedOnDateAndEmp(t, dur, "katachorish", null, calendar);
						JOptionPane.showMessageDialog(fr, "Please answer the following questions about our website!");
						Evaluation.evaluateProcedure();

					} else {
						JOptionPane.showMessageDialog(fr, "You have to choose one of the two criteria!");
					}

				} else if (clientChoice.contains("2")) {

					int[] del = new int[3];
					String answerdelete = "YES";

					while (answerdelete.contains("YES")) {
						del = DeleteAndChange.deleteQuestions();
						answerdelete = DeleteAndChange.deleteAppointment(del, calendar);
					}

				} else if (clientChoice.contains("3")) {
					int del2[] = DeleteAndChange.changeQuestions();
					DeleteAndChange.changeAppointment(del2, calendar);

				} else if (clientChoice.contains("4")) {
					Evaluation.evaluate();

				} else {
					JOptionPane.showMessageDialog(fr, "You have to choose one of the two options!");
				}

			} else if (identity.contains("BUSINESS")) {

				String compChoice = JOptionPane.showInputDialog(fr, "Please choose a service"
						+ "\r\n (1)SHOW STATISTICS" + "\r\n (2)MODIFY INFORMATION " + "\r\n (choose 1 or 2)");

				if (compChoice.contains("1")) {
					Statistics.statQuestions(args);

				} else if (compChoice.contains("2")) {
					String anscomp = JOptionPane.showInputDialog(fr,
							"(1)MODIFY SERVICES" + "\r\n (2)MODIFY INFORMATION OF EMPLOYEES" + "\r\n (choose 1 or 2)");

					if (anscomp.equals("1")) {
						Services.changeServcices();

					} else if (anscomp.equals("2")) {
						Employees.changeEmployees();

					} else {
						JOptionPane.showMessageDialog(fr, "You have to choose 1 or 2 !!");
					}

				} else {
					JOptionPane.showMessageDialog(fr, "You have to choose between the two options!");
				}

			} else {
				JOptionPane.showMessageDialog(fr, "You have to insert your identity correctly !");
			}
			pl++;
		}
	}

}
