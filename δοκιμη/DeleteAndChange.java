import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This class deletes and changes an already booked appointment.
 *
 */
public class DeleteAndChange {

	static Scanner sc = new Scanner(System.in);
	static JFrame frame;

	/**
	 * This method asks from client to insert the date of the appointment he wants
	 * to delete as well as the validation code he has been given when he booked the
	 * appointment. This information is being saved in an integer table of size
	 * three. The method returns this table.
	 * 
	 * @return = an integer table of size three
	 */
	public static int[] deleteQuestions() {

		int[] del = new int[3];

		/*
		 * System.out.
		 * println("Επιλέξατε να διαγράψετε κάποιο ήδη καταχωρημένο ραντεβού σας!");
		 * System.out.
		 * println("Παρακαλώ εισάγετε τον κωδικο επιβεβαιωσης και την ημερομηνία του ραντεβού σας!"
		 * ); System.out.println("Μήνας:");
		 */
		JOptionPane.showMessageDialog(frame, "You chose to delete an already booked appointment!"
				+ "\r\n Please insert your validation code and the date of the appointment!");

		boolean error = true;
		while (error) {
			try {
				/* int month = sc.nextInt(); */
				String mon = JOptionPane.showInputDialog(frame, "Month:");
				int month = Integer.parseInt(mon);
				del[0] = month;

				String d = JOptionPane.showInputDialog(frame, "Day:");
				int day = Integer.parseInt(d);
				del[1] = day;

				String val = JOptionPane.showInputDialog(frame, "Validation Code:");
				int validcode = Integer.parseInt(val);
				del[2] = validcode;
				error = false;
			} catch (InputMismatchException e1) {
				/* System.err.println("you should insert the correct type of info") */;
				JOptionPane.showMessageDialog(null, "you should insert the correct type of info", "Error message",
						JOptionPane.ERROR_MESSAGE);
			} catch (ArrayIndexOutOfBoundsException e2) {
				/* System.err.println("you have an error."); */
				JOptionPane.showMessageDialog(null, "you have an array error.", "Error message",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		return del;

	}

	/**
	 * This method tracks the appointment based on the validation code that the
	 * client inserted and deletes it from the appointment table.
	 * 
	 * @param del      = that's where the client's info and his validation code are
	 *                 saved
	 * @param calendar = the appointment table for this specific day
	 * 
	 * @return = returns "NO" when an appointment has been successfully deleted or
	 *         when the client regretted his choice. Returns "YES" when the method
	 *         must be recalled.
	 */
	public static String deleteAppointment(int[] del, Table[][] calendar) {

		String answer = "ΟΧΙ";

		String category = "";
		boolean found = false;
		boolean error = true;
		while (error) {
			try {
				for (int i = 1; i <= 16; i++) {

					for (int j = 1; j <= Employees.employees.size(); j++) {

						if (calendar[del[0]][del[1]].getTable()[i][j].toLowerCase().contains(String.valueOf(del[2]))) {
							// IF THE CODE ON TABLE IS THE SAME WITH THE CODE THAT THE CLIENT INSERTS

							for (int e = 0; e < Employees.employees.size(); e++) {
								String name = Employees.employees.get(e).getEmp_name();
								if (name.contains(calendar[del[0]][del[1]].getTable()[0][j])) {
									category = Employees.employees.get(e).getSpecialty();
								}
							}
							found = true;

							// FINDS HOW MANY CELLS OF TABLE TAKES UP THE APPOINTMENT
							cancelTable(del[0], del[1], j, del[2], i, calendar);
						}
					} // END INSIDE FOR
				} // END OUTSIDE FOR

				error = false;
			} catch (ArrayIndexOutOfBoundsException e) {

				/* System.err.println("there is an array error."); */
				JOptionPane.showMessageDialog(null, "there is an array error.", "Error message",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		error = true;
		int pl = 0;
		while (error) {
			try {

				if (pl < 1) {
					if (found == false) {
						/*
						 * System.out.println("Δυστυχως δεν βρηκαμε καποιο " +
						 * "καταχωρημένο ραντεβού με τον κωδικό \nπου εισάγατε. Θελετε να προσπαθήσετε ξανα;  \nΝΑΙ / ΟΧΙ"
						 * ); sc.nextLine(); answer = sc.nextLine();
						 */
						answer = JOptionPane.showInputDialog(frame, "Unfortunately we didn't find any "
								+ "booked appointments with the validation code \nyou inserted. Do you want to try again?  \nYES / NO");

					} else {
						/*
						 * System.out.println("Το ραντεβού σας διεγράφη."); System.out.println();
						 */
						JOptionPane.showMessageDialog(frame, "Your appointment has been deleted successfully");
						answer = "ΟΧΙ";
						Menu.sumMinus(category);
					}
					error = false;
				} else {

				}
			} catch (InputMismatchException e) {
				/* System.err.println("you should insert the correct type of info."); */
				JOptionPane.showMessageDialog(null, "you should insert the correct type of info.", "Error message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return answer;
	} // END OF METHOD

	/**
	 * This method replaces every cell of the appointment table with the word "NO".
	 * This happens at the cells that contain the validation code of the appointment
	 * that the client wants to delete or change.
	 * 
	 * 
	 * @param month      = the month that the appointment is booked
	 * @param day        = the day that the appointment is booked
	 * @param column     = the column of the appointment table where the appointment
	 *                   starts
	 * @param clientcode = the validation code the client inserted
	 * @param line       = the line of the appointment table where the appointment
	 *                   starts
	 * @param calendar   = the appointment table
	 */
	public static void cancelTable(int month, int day, int column, int clientcode, int line, Table[][] calendar) {

		boolean exists = true;

		do { // WHILE LOOP PUTS "NO" INSIDE THE CELLS THAT CONΤΑINS CLIENT'S VALIDCODE
			boolean error = true;
			while (error) {
				try {
					if (calendar[month][day].getTable()[line][column].toLowerCase()
							.contains(String.valueOf(clientcode))) {
						while (calendar[month][day].getTable()[line][column].toLowerCase()
								.contains(String.valueOf(clientcode))) {

							calendar[month][day].getTable()[line][column] = "      ΟΧΙ";
							line++;
						}
					} else {
						exists = false;
					}
					error = false;
				} catch (ArrayIndexOutOfBoundsException e) {
					/* System.err.println("you have an array error."); */
					JOptionPane.showMessageDialog(null, "you have an array error.", "Error message",
							JOptionPane.ERROR_MESSAGE);

				} // end of try/catch
			}

		} while (exists == true);

	}

	/**
	 * This method asks from client to insert the date of the appointment he wants
	 * to change as well as the validation code he has been given when he booked the
	 * appointment. This information is being saved in an integer table of size
	 * three. The method returns this table.
	 * 
	 * @return = returns an integer table of size three
	 */
	public static int[] changeQuestions() {

		int[] del2 = new int[3];
		/*
		 * System.out.
		 * println("Επιλέξατε να αλλαξετε κάποιο ήδη καταχωρημένο ραντεβού σας!");
		 * System.out.println(
		 * "Παρακαλώ εισάγετε τον κωδικο επιβεβαιωσης και την ημερομηνία του καταχωρημένου ραντεβού σας!"
		 * ); System.out.println();
		 */
		JOptionPane.showMessageDialog(frame, "You chose to change an already booked appointment!"
				+ "\r\n Please insert your validation code and the date of the appointment! ");

		boolean error = true;

		while (error) {
			try {
				/*
				 * System.out.println("Μήνας:"); int month = sc.nextInt();
				 */
				String mo = JOptionPane.showInputDialog(frame, "Month:");
				int month = Integer.parseInt(mo);
				del2[0] = month;
				/*
				 * System.out.println("Ημέρα:"); int day = sc.nextInt();
				 */
				String da = JOptionPane.showInputDialog(frame, "Day:");
				int day = Integer.parseInt(da);

				del2[1] = day;
				/*
				 * System.out.println("Κωδικος:"); int validcode = sc.nextInt();
				 */
				String validcod = JOptionPane.showInputDialog(frame, "Validation Code:");
				int validcode = Integer.parseInt(validcod);
				del2[2] = validcode;
				error = false;

			} catch (InputMismatchException e) {
				/* System.err.println("you should insert the correct type of info."); */
				JOptionPane.showMessageDialog(null, "you should insert the correct type of info.", "Error message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return del2;

	}

	/**
	 * This method finds the client's info (name, surname, phone number) using the
	 * validation code the client inserted and saves that info in a string table of
	 * size three.
	 * 
	 * 
	 * @param stringcode = the validation code the client inserted
	 * @param del2       = the table where the date and the validation code of the
	 *                   appointment have been saved
	 * @param calendar   = the appointment table
	 * 
	 * @return = returns a string table of size three which includes the name, the
	 *         surname and the phone number of the client
	 */
	public static String[] customerΙnfo(String stringcode, int[] del2, Table[][] calendar) {

		boolean flag = false;
		String[] info2 = new String[3];

		String stringid = null;
		int intid = 0;

		boolean error = true;
		while (error) {
			try {
				for (int i = 1; i <= 16; i++) {
					for (int y = 1; y <= Employees.employees.size(); y++) {
						if (calendar[del2[0]][del2[1]].getTable()[i][y].toLowerCase().contains(stringcode)) {
							stringid = calendar[del2[0]][del2[1]].getTable()[i][y]
									.substring(calendar[del2[0]][del2[1]].getTable()[i][y].length() - 3);
							// THE ABOVE LINE: SEPARATES ID FROM VALIDCODE

							intid = Integer.parseInt(stringid);
							flag = true; // TURNS TRUE WHEN CLIENT IS SPOTTED
							break;
						}
					}
					if (flag == true) {
						break;
					}
				}
				for (int i = 0; i < Client.clients.size(); i++) {
					if (Client.clients.get(i).getId() == intid) {
						info2[0] = Client.clients.get(i).getName();
						info2[1] = Client.clients.get(i).getSurname();
						String stringphone = String.valueOf(Client.clients.get(i).getPhoneNumber());
						info2[2] = stringphone;
					}
				}
				error = false;
			} catch (ArrayIndexOutOfBoundsException e) {
				/* System.err.println("there is an array error."); */
				JOptionPane.showMessageDialog(null, "there is an array error.", "Error message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return info2;
	}

	/**
	 * This method finds the information of the appointment (examination, name of
	 * doctor, category of examination) that the client wants to change using the
	 * validation code he inserted. This informations is being saved in a string
	 * table of size three.
	 * 
	 * @param del2     = the table where the name,surname and validation code of the
	 *                 client have been saved
	 * @param calendar = the appointment table
	 * 
	 * @return = returns a string table of size three containing the examination,
	 *         its category and the name of the doctor of the appointment the client
	 *         wants to change
	 */
	public static String[] keepInfo(int[] del2, Table[][] calendar) {

		String exetasi = null;
		String doctor = null;
		String eidikotita = null;
		String[] info = new String[3];

		try {
			for (int i = 1; i <= 16; i++) {

				for (int j = 1; j <= Employees.employees.size(); j++) {

					if (calendar[del2[0]][del2[1]].getTable()[i][j].toLowerCase().contains(String.valueOf(del2[2]))) {// FIND
																														// THE
																														// APPOINTMENT
																														// ON
																														// TABLE

						exetasi = calendar[del2[0]][del2[1]].getTable()[i][j]; // NAME OF SERVICE
																				// IN OLD APPOINTMENT
						doctor = calendar[del2[0]][del2[1]].getTable()[0][j]; // NAME OF EMPLOYEE IN OLD APPOINTMENT
						eidikotita = Employees.employees.get(j).getSpecialty(); // CATEGORY OF SERVICE IN OLD
																				// APPOINTMENT

						info[0] = exetasi;
						info[1] = doctor;
						info[2] = eidikotita;
					} // END INSIDE IF

				} // END INSIDE FOR

			} // END OUTSIDE FOR

		} catch (ArrayIndexOutOfBoundsException e) {
			/* System.err.println("there is an array error."); */
			JOptionPane.showMessageDialog(null, "there is an array error.", "Error message", JOptionPane.ERROR_MESSAGE);
		}
		return info;

	}// end of method ans1

	/**
	 * This method finds the duration and the cost of a certain examination of the
	 * medical center.It saves these two values in a double table of size two.
	 * 
	 * @param category    = the category of the examination
	 * @param examination = the name of the examination
	 * 
	 * @return = returns a double table of size two where the duration and cost of
	 *         the examination have been saved
	 */
	public static double[] keepInfoDuration(String category, String examination) {

		double[] exetasi_duration = new double[2];

		for (int i = 0; i < Services.eidikotitesoles.size(); i++) {

			if (Services.eidikotitesoles.get(i).get(0).getCategory().contains(category)) { // SERVICE BELONGS AT THIS
																							// CERTAIN
				// SUBLIST
				// for example AIMATOLOGIKES
				for (int j = 0; j < Services.eidikotitesoles.get(i).size(); j++) {

					if (examination.equals(Services.eidikotitesoles.get(i).get(j).getName())) { // FIND THE SERVICE AT
						// THE LIST
						exetasi_duration[0] = Services.eidikotitesoles.get(i).get(j).getDuration();
						exetasi_duration[1] = Services.eidikotitesoles.get(i).get(j).getCost();
					}
				} // END INSIDE FOR
			}
		} // END OUTSIDE FOR
		return exetasi_duration;
	}// end of method

	/**
	 * In this method the client chooses whether he wants to book a new appointment
	 * keeping the information of the old one or not. If he chooses "YES", some of
	 * the above methods are being called and the information of the previous
	 * appointment is being saved in a string table of size 5 (client name, surname,
	 * phone number, examination and duration of the examination). Then, a new
	 * appointment is being booked. If the client chooses "NO", he books a
	 * completely new appointment.
	 * 
	 * @param del2     = the table where client's name,surname and validation code
	 *                 have been saved
	 * @param calendar = the appointment table
	 */
	public static void changeAppointment(int del2[], Table[][] calendar) {

		String answer = null;
		/*
		 * System.out.
		 * println("Για την μεταφορά του ραντεβού σας απαιτείται διαγραφή του ήδη υπάρχοντος. "
		 * +
		 * "Ειστε βεβαιοι για την διαγραφη του προηγούμενου ραντεβου σας; \nΝΑΙ / ΟΧΙ");
		 * sc.nextLine(); answer = sc.nextLine();
		 */
		answer = JOptionPane.showInputDialog(frame,
				"To transfer your appointment we have to delete the already existing one. "
						+ "Do you want to delete your old appointment? \nYES / NO");

		String[] info2 = new String[5];
		double[] exetasi_duration = new double[2];
		String t1[] = new String[3];
		String[] info = new String[3];
		info = keepInfo(del2, calendar);

		try {
			if (answer.contains("YES")) {

				String answerdelete = deleteAppointment(del2, calendar); // DELETE OLD APPOINTMENT USING DELETION METHOD
				while (answerdelete.contains("YES")) {
					answerdelete = deleteAppointment(del2, calendar); // DELETE OLD APPOINTMENT USING DELETION METHOD
				}

				Menu.sumMinus(info[2]);

				/*
				 * System.out.println("Για την μεταφορά του ραντεβού " +
				 * "σας επιθυμείτε να διατηρήσουμε τα ήδη υπάρχοντα στοιχεία του ραντεβού; \nΝΑΙ / ΟΧΙ"
				 * ); String ans = sc.nextLine();
				 */
				String ans = JOptionPane.showInputDialog(frame, "To transfer your appointment "
						+ "would you like to keep the information of the old one? \nYES / NO");

				if (ans.contains("YES")) {

					exetasi_duration = keepInfoDuration(info[2], info[0]);
					info2 = customerΙnfo(String.valueOf(del2[2]), del2, calendar); // FILLS THE FIRST 3 CELLS OF
																					// TABLE
																					// WITH CLIENTs INFO

					info2[3] = info[0];
					info2[4] = String.valueOf(exetasi_duration);

					t1[1] = info[2];
					t1[2] = info[0];
					t1[0] = "γιατρού";

					/*
					 * System.out.
					 * println("Θα θέλατε να διατηρήσετε τον ίδιο γιατρό και στο νέο σας ραντεβου;"
					 * ); String keep_doc = sc.next();
					 */
					String keep_doc = JOptionPane.showInputDialog(frame,
							"Would you like to keep the same doctor for the new appointment? \nYES / NO");

					if (keep_doc.equals("YES")) {
						EnterAppointment.basedOnDateAndEmp(t1, exetasi_duration, "no", info[1], calendar);
					} else {
						EnterAppointment.basedOnDate(t1, exetasi_duration, calendar, "no");
					}

				} else { // COMPLETELY NEW APPOINTMENT

					String[] t = EnterAppointment.questionsToBegin();

					double[] duration = new double[2];
					duration = EnterAppointment.choiceDuration(t);

					if (t[0].contains("1")) { // CHOOSE BASED ON DATE
						EnterAppointment.basedOnDate(t, duration, calendar, "katachorish");

					} else { // BASED ON EMPLOYEE

						EnterAppointment.basedOnDateAndEmp(t, duration, "katachorish", info[1], calendar);
					}
				}
			} else {
				JOptionPane.showMessageDialog(frame, "We didn't manage to change your old appointment!");
			}

		} catch (InputMismatchException e1) {

			/* System.err.println("you should insert the correct type of info."); */
			JOptionPane.showMessageDialog(null, "you should insert the correct type of info.", "Error message",
					JOptionPane.ERROR_MESSAGE);

		} catch (ArrayIndexOutOfBoundsException e2) {

			JOptionPane.showMessageDialog(null, "there is an array error.", "Error message", JOptionPane.ERROR_MESSAGE);
		}
	}

}// END OF CLASS
