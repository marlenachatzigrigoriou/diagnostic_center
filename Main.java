package javaTest;

import java.util.Scanner;
/**
 * @author HP
 *
 */

public class Main {

	public static Scanner in = new Scanner(System.in);

	public static void loadObjects(Table[][] calendar, String path) { 	// CREATE Services, Employees,
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
					System.err.println("Λάθος καταχωρημένο στοιχείο στo αρχείo " + Services.eidikotites.get(i)
							+ " που χρησιμοποιήσατε!");
					System.err.println("Διορθώστε το αρχείο και επανεισάγετέ το!");
					path = in.nextLine();
				}

			}
		}
		err = true;
		while (err) {

			try {
				CreateObjects.createEmployees("C:\\Users\\HP\\Desktop\\java2_\\exe2\\employees.txt");
				err = false;
			} catch (NumberFormatException e) {
				System.err.println("Λάθος καταχωρημένο στοιχείο στo αρχείo employees που χρησιμοποιήσατε!");
			}
		}

		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 30; j++) {
				Table table = new Table();
				calendar[i][j] = table;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		String clientChoice;
		String identity;
		Table calendar[][] = new Table[13][31];
		int pl = 0;
		loadObjects(calendar, "C:\\Users\\HP\\Desktop\\java2_\\exe2\\");
		Evaluation.loadEvaluation();

		for (;;) {

			System.out.println("ΕΠΙΧΕΙΡΗΣΗ / ΠΕΛΑΤΗΣ");
			if (pl > 1) {
				//in.nextLine();
				identity = in.next();
			} else {
				identity = in.next();
			}

			if (identity.contains("ΠΕΛΑΤΗΣ")) {

				System.out.println(
						"(1)Καταχώρηση Ραντεβού \n\n(2)Διαγραφή ραντεβού \n\n(3)Αλλαγή ραντεβού \n\n(4)Αξιολόγιση Πολυιατρικού κέντρου"
								+ "\n---------------------------------------");
				clientChoice = in.next();

				if (clientChoice.contains("Καταχώρηση")) {

					Client.questionsAboutClient();
					String t[] = EnterAppointment.questionsToBegin();
					double dur[] = EnterAppointment.choiceDuration(t);
					String ans = t[0];

					if (ans.equals("1")) {

						EnterAppointment.basedOnDate(t, dur, calendar, "katachorish");

					} else if (ans.equals("2")) {

						EnterAppointment.basedOnDateAndEmp(t, dur, "katachorish", null, calendar);

					} else {
						System.out.println("Πρέπει να επιλέξετε ένα απο τα δύο κριτήρια!");
					}

					System.out.println("Παρακαλούμε απαντήστε τις παρακάτω ερωτήσεις σχετικά με την ιστοσελίδα!"
							+ "\n------------------------------------------------------------------------");
					Evaluation.evaluateProcedure();

				} else if (clientChoice.contains("Διαγραφή")) {

					int[] del = new int[3];
					String answerdelete = "ΝΑΙ";

					while (answerdelete.contains("ΝΑΙ")) {
						del = DeleteAndChange.deleteQuestions();
						answerdelete = DeleteAndChange.deleteAppointment(del, calendar);
					}

				} else if (clientChoice.contains("Αλλαγή")) {

					int del2[] = DeleteAndChange.changeQuestions();
					DeleteAndChange.changeAppointment(del2, calendar);

				} else if (clientChoice.contains("Αξιολόγιση")) {
					Evaluation.evaluate();

				} else {
					System.out.println("Πρέπει να διαλέξετε μία απο τις παραπάνω επιλογές");
					System.out.println();
				}

				// JUST CHECKING THE TABLE Table-------------
				System.out.println();
				System.out.println();
				for (int i = 0; i <= 16; i++) {
					for (int j = 0; j <= Employees.employees.size(); j++) {
						System.out.print(calendar[4][1].getTable()[i][j]);
					}
					System.out.println();
				}
				System.out.println();
				System.out.println();
				//--------------------------------------------

			} else if (identity.contains("ΕΠΙΧΕΙΡΗΣΗ")) {

				System.out.println("(1)ΕΞΑΓΩΓΗ ΣΤΑΤΙΣΤΙΚΩΝ \n\n(2)ΑΛΛΑΓΗ ΣΤΟΙΧΕΙΩΝ \n\n(επιλέξτε 1 ή 2)"
						+ "\n-----------------------------");
				String compChoice = in.next();

				if (compChoice.contains("1")) {

					Statistics.statQuestions(args);
					

				} else if (compChoice.contains("2")) {

					System.out.println(
							"(1)ΑΛΛΑΓΗ ΣΤΟΙΧΕΙΩΝ ΥΠΗΡΕΣΙΩΝ \n\n(2)ΑΛΛΑΓΗ ΣΤΟΙΧΕΙΩΝ ΥΠΑΛΛΗΛΩΝ \n\n(επιλέξτε 1 ή 2)"
									+ "\n--------------------------------------------");
					String anscomp = in.next();

					if (anscomp.equals("1")) {
						
						Services.changeServcices();
						
					} else if (anscomp.equals("2")) {
						
						Employees.changeEmployees();
				
					} else {
						System.out.println("Πρέπει να εισάγετε 1 ή 2 !!");
					}

				} else {
					System.out.println("Πρέπει να επιλέξετε μία εκ των δύο επιλογών!");
				}

			} else {
				System.out.println("Πρεπει να εισάγετε σωστά την ιδιότητά σας !");
			}
			pl++;
			System.out.println();
		}

	}

}