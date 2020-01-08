import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DeleteAndChange {
    static JFrame frame;
	static Scanner sc = new Scanner(System.in);
	
	public static int[] deleteQuestions() { // ΕΙΣΑΓΩΓΗ ΚΩΔ ΕΠΙΒΕΒ. ΚΑΙ ΗΜΕΡΟΜΗΝΙΑ
		
		int [] del = new int[3];
			
		/*System.out.println("Επιλέξατε να διαγράψετε κάποιο ήδη καταχωρημένο ραντεβού σας!");
		System.out.println("Παρακαλώ εισάγετε τον κωδικο επιβεβαιωσης και την ημερομηνία του ραντεβού σας!");
		System.out.println("Μήνας:");*/
		JOptionPane.showMessageDialog(frame,"Επιλέξατε να διαγράψετε κάποιο ήδη καταχωρημένο ραντεβού σας!"
				+"\r\n Παρακαλώ εισάγετε τον κωδικο επιβεβαιωσης και την ημερομηνία του ραντεβού σας!");
		
		boolean error = true;
		while (error) {
			try {
				/*int month = sc.nextInt();*/
				String mon=JOptionPane.showInputDialog(frame,"Μήνας:");
				int month=Integer.parseInt(mon);
				del[0] = month;
				
				String d=JOptionPane.showInputDialog(frame,"Ημέρα:");
				int day=Integer.parseInt(d);
				del[1] = day;
				
				String val=JOptionPane.showInputDialog(frame,"Κωδικος:");
				int validcode = Integer.parseInt(val);
				del[2] = validcode;
				error = false;
			} catch (InputMismatchException e1) {
				/*System.err.println("you should insert the correct type of info")*/;
				JOptionPane.showMessageDialog(null, "you should insert the correct type of info", "Error message",
						JOptionPane.ERROR_MESSAGE);
			} catch (ArrayIndexOutOfBoundsException e2) {
				/*System.err.println("you have an error.");*/
				JOptionPane.showMessageDialog(null, "you have an array error.", "Error message",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		return del;
		
	}

	
	// αρα εδω παιρνεις ως ορισματα ένα ενα τα κελια του del --> γιατι όχι ολο τον  del κατευθείαν 
	//και μέσα στην μεθοδο να παιρνεις το 0 ή 1 κλπ ;;;;;
	public static void cancelTable(int month, int day, int j, int cell, int k_value, Table[][] calendar) { 

		boolean exists = true;
		int k = k_value;
		do { // WHILE LOOP PUTS "NO" INSIDE THE CELLS THAT CONATINS CLIENT'S VALIDCODE
			
			boolean error = true;
			while (error) {
				try {
					if (calendar[month][day].getTable()[k][j].toLowerCase().contains(String.valueOf(cell))) {

						calendar[month][day].getTable()[k][j] = "      ΟΧΙ";
						k++;
					} else {
						exists = false;
					}
					error = false;
				} catch (ArrayIndexOutOfBoundsException e) {
					/*System.err.println("you have an array error.");*/
					JOptionPane.showMessageDialog(null, "you have an array error.", "Error message",
							JOptionPane.ERROR_MESSAGE);

				} // end of try/catch
			}
			
		} while (exists == true);
		
		
	}
	
	

	public static String[] customerΙnfo(String stringcode, int[] del2, Table[][] calendar) {

		boolean flag = false;
		String[] info2 = new String[5];

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

				/*System.err.println("there is an array error.");*/
				JOptionPane.showMessageDialog(null, "there is an array error.", "Error message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return info2;
	}
	
	public static String deleteAppointment(int[] del, Table[][] calendar) {

		String answer = "OXI";

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

					/*System.err.println("there is an array error.");*/
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
							/*System.out.println("Δυστυχως δεν βρηκαμε καποιο "
									+ "καταχωρημένο ραντεβού με τον κωδικό \nπου εισάγατε. Θελετε να προσπαθήσετε ξανα;  \nΝΑΙ / ΟΧΙ");
							sc.nextLine();
							answer = sc.nextLine();*/
							answer=JOptionPane.showInputDialog(frame,"Δυστυχως δεν βρηκαμε καποιο "
									+ "καταχωρημένο ραντεβού με τον κωδικό \nπου εισάγατε. Θελετε να προσπαθήσετε ξανα;  \nΝΑΙ / ΟΧΙ");
			
						} else {
							/*System.out.println("Το ραντεβού σας διεγράφη.");
							System.out.println();*/
							JOptionPane.showMessageDialog(frame,"Το ραντεβού σας διεγράφη.");
							answer = "OXI";
							Menu.sumMinus(category);
						}
						error = false;
					} else {

					}
				} catch (InputMismatchException e) {
					/*System.err.println("you should insert the correct type of info.");*/
					JOptionPane.showMessageDialog(null, "you should insert the correct type of info.", "Error message",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		return answer;
	} // END OF METHOD

	
	
	public static int[] changeQuestions() { // INSERTS VALIDCODE AND DATE
		
		int[] del2 = new int[3];
		/*System.out.println("Επιλέξατε να αλλαξετε κάποιο ήδη καταχωρημένο ραντεβού σας!");
		System.out.println(
				"Παρακαλώ εισάγετε τον κωδικο επιβεβαιωσης και την ημερομηνία του καταχωρημένου ραντεβού σας!");
		System.out.println();*/
		JOptionPane.showMessageDialog(frame,"Επιλέξατε να αλλαξετε κάποιο ήδη καταχωρημένο ραντεβού σας!"
				+"\r\n Παρακαλώ εισάγετε την ημερομηνία και τον κωδικο επιβεβαιωσης του καταχωρημένου ραντεβού σας! ");
				
		
		boolean error = true;
		
		
		while (error) {
			try {
				/*System.out.println("Μήνας:");
				int month = sc.nextInt();*/
				String mo=JOptionPane.showInputDialog(frame,"Μήνας:");
				int month=Integer.parseInt(mo);
				del2[0] = month;
				/*System.out.println("Ημέρα:");
				int day = sc.nextInt();*/
				String da=JOptionPane.showInputDialog(frame,"Ημέρα:");
				int day=Integer.parseInt(da);
				
				del2[1] = day;
				/*System.out.println("Κωδικος:");
				int validcode = sc.nextInt();*/
				String validcod=JOptionPane.showInputDialog(frame,"Κωδικος:");
				int validcode=Integer.parseInt(validcod);
				del2[2] = validcode;
				error = false;
				
			} catch (InputMismatchException e) {
				/*System.err.println("you should insert the correct type of info.");*/
				JOptionPane.showMessageDialog(null, "you should insert the correct type of info.", "Error message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return del2;

	}

	public static void changeAppointment(int del2[], Table[][] calendar) {

		String answer = null;
		/*System.out.println("Για την μεταφορά του ραντεβού σας απαιτείται διαγραφή του ήδη υπάρχοντος. "
				+ "Ειστε βεβαιοι για την διαγραφη του προηγούμενου ραντεβου σας; \nΝΑΙ / ΟΧΙ");
		sc.nextLine();
		answer = sc.nextLine();*/
		answer=JOptionPane.showInputDialog(frame,"Για την μεταφορά του ραντεβού σας απαιτείται διαγραφή του ήδη υπάρχοντος. "
				+ "Ειστε βεβαιοι για την διαγραφη του προηγούμενου ραντεβου σας; \nΝΑΙ / ΟΧΙ");

		String[] info2 = new String[5];
		double[] exetasi_duration = new double[2];
		String t1[] = new String[3];
		String[] info = new String[3];
		info = keepInfo(del2, calendar);

		try {
			if (answer.contains("ΝΑΙ")) {

				String answerdelete = deleteAppointment(del2, calendar); // DELETE OLD APPOINTMENT USING DELETION METHOD
				while (answerdelete.contains("ΝΑΙ")) {
					answerdelete = deleteAppointment(del2, calendar); // DELETE OLD APPOINTMENT USING DELETION METHOD
				}

				Menu.sumMinus(info[2]);

				/*System.out.println("Για την μεταφορά του ραντεβού "
						+ "σας επιθυμείτε να διατηρήσουμε τα ήδη υπάρχοντα στοιχεία του ραντεβού; \nΝΑΙ / ΟΧΙ");
				String ans = sc.nextLine();*/
				String ans= JOptionPane.showInputDialog(frame,"Για την μεταφορά του ραντεβού "
						+ "σας επιθυμείτε να διατηρήσουμε τα ήδη υπάρχοντα στοιχεία του ραντεβού; \nΝΑΙ / ΟΧΙ");

				if (ans.contains("ΝΑΙ")) {

					exetasi_duration = keepInfoDuration(info[2], info[0]);
					info2 = customerΙnfo(String.valueOf(del2[2]), del2, calendar); // FILLS THE FIRST 3 CELLS OF
																					// TABLE
																					// WITH CLIENTs INFO

					info2[3] = info[0];
					info2[4] = String.valueOf(exetasi_duration);

					t1[1] = info[2];
					t1[2] = info[0];
					t1[0] = "γιατρού";

					/*System.out.println("Θα θέλατε να διατηρήσετε τον ίδιο γιατρό και στο νέο σας ραντεβου;");
					String keep_doc = sc.next();*/
					String keep_doc=JOptionPane.showInputDialog(frame,"Θα θέλατε να διατηρήσετε τον ίδιο γιατρό και στο νέο σας ραντεβου; \nΝΑΙ / ΟΧΙ");

					if (keep_doc.equals("ΝΑΙ")) {
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
				JOptionPane.showMessageDialog(frame,"Το παλιό σας ραντεβού δεν τροποποιήθηκε!");
			}

		} catch (InputMismatchException e1) {

			/*System.err.println("you should insert the correct type of info.");*/
			JOptionPane.showMessageDialog(null, "you should insert the correct type of info.", "Error message",
					JOptionPane.ERROR_MESSAGE);

		} catch (ArrayIndexOutOfBoundsException e2) {

			JOptionPane.showMessageDialog(null, "there is an array error.", "Error message",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static String[] keepInfo(int[] del2, Table[][] calendar) {

		String exetasi = null;
		String doctor = null;
		String eidikotita = null;
		String[] info = new String[3];

		
		try {
			for (int i = 1; i <= 16; i++) {

				for (int j = 1; j <= Employees.employees.size(); j++) {					
				
					if (calendar[del2[0]][del2[1]].getTable()[i][j].toLowerCase()
							.contains(String.valueOf(del2[2]))) {// FIND THE APPOINTMENT ON TABLE

						exetasi = calendar[del2[0]][del2[1]].getTable()[i][j];              // NAME OF SERVICE
																							// IN OLD APPOINTMENT
						doctor = calendar[del2[0]][del2[1]].getTable()[0][j]; // NAME OF EMPLOYEE IN OLD APPOINTMENT
						eidikotita = Employees.employees.get(j).getSpecialty(); // CATEGORY OF SERVICE IN OLD APPOINTMENT

						info[0] = exetasi;
						info[1] = doctor;
						info[2] = eidikotita;
					} // END INSIDE IF

				} // END INSIDE FOR

			} // END OUTSIDE FOR
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			/*System.err.println("there is an array error.");*/
			JOptionPane.showMessageDialog(null, "there is an array error.", "Error message",
					JOptionPane.ERROR_MESSAGE);

		}
		return info;

	}// end of method ans1

	
	
	public static double [] keepInfoDuration(String a, String b) {

		double [] exetasi_duration = new double[2];

		for (int i = 0; i < Services.eidikotitesoles.size(); i++) {
		
			if (Services.eidikotitesoles.get(i).get(0).getCategory().contains(a)) { // SERVICE BELONGS AT THIS CERTAIN
																					// SUBLIST
																					// for example AIMATOLOGIKES
				for (int j = 0; j < Services.eidikotitesoles.get(i).size(); j++) {

					if (b.equals(Services.eidikotitesoles.get(i).get(j).getName())) { // FIND THE SERVICE AT
																						// THE LIST
						exetasi_duration[0] = Services.eidikotitesoles.get(i).get(j).getDuration();
						exetasi_duration[1] = Services.eidikotitesoles.get(i).get(j).getCost();	
					}
				} // END INSIDE FOR
			}
		} // END OUTSIDE FOR
		return exetasi_duration;
	}// end of method ans1duration

}// END OF CLASS

