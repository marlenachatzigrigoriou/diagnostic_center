import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class EnterAppointment {

	static Scanner m = new Scanner(System.in);
    static JFrame frame;
	public static String[] questionsToBegin() {

		String[] t1 = new String[3];
		boolean found = false;

		String eidikotita = Menu.chooseService();
		t1[1] = eidikotita;
		/*System.out.println("Αναζήτηση:");
		String search = m.next();
		*/
		String search = JOptionPane.showInputDialog(frame,"Αναζητήστε την εξέταση που επιθυμείτε \n"
				+ "(εισάγετε ΟΛΕΣ για την εκτύπωση όλων των εξετάσεων της κατηγορίας):");
		do {
			if (Menu.filterAndPrintServices(search, eidikotita) == false) {
				/*System.out.println("Είστε βέβαιοι ότι επιθυμείτε την υπηρεσία: " + eidikotita + ";\n"
						+ "*ναι (νέα προσπάθεια για αναζήτηση εξέτασης)\n*όχι (νέα επιλογή κατηγορίας εξετάσεων)");
				String a = m.next();*/
				
				String a = JOptionPane.showInputDialog(frame,"Είστε βέβαιοι ότι επιθυμείτε την υπηρεσία: " + eidikotita 
						  +"\r\n *ναι (νέα προσπάθεια για αναζήτηση εξέτασης)"
						  +"\r\n *όχι (νέα επιλογή κατηγορίας εξετάσεων)");
						
				if (a.contains("ναι")) {
					/*System.out.println("Αναζήτηση:");
					search = m.next();*/
					search = JOptionPane.showInputDialog(frame,"Αναζητήστε την εξέταση που επιθυμείτε \n"
							+ "(εισάγετε ΟΛΕΣ για την εκτύπωση όλων των εξετάσεων της κατηγορίας):");
				} else {
					eidikotita = Menu.chooseService();
					t1[1] = eidikotita;
					/*System.out.println("Αναζήτηση:");
					search = m.next();*/
					search = JOptionPane.showInputDialog(frame,"Αναζητήστε την εξέταση που επιθυμείτε \n"
							+ "(εισάγετε ΟΛΕΣ για την εκτύπωση όλων των εξετάσεων της κατηγορίας):");
				}

			} else {
				found = true;
			}
		} while (!found);

		//m.nextLine();
		/*String choice = m.nextLine();*/
		String choice=JOptionPane.showInputDialog(frame,"Εισάγετε την εξέταση (από όσες αναφέρθηκαν\n προηγουμένως) που επιθυμείτε:");
		t1[2] = choice;

		String ans = Menu.chooseCriterion(); 
		t1[0] = ans;
		
		return t1;
	}

	
	public static double[] choiceDuration(String[] t1) {

		double[] duration = new double[2];

		for (int j = 0; j < 22; j++) {

			if (t1[1].toLowerCase().contains(Services.eidikotites.get(j))) {

				for (int i = 0; i < Services.eidikotitesoles.get(j).size(); i++) {

					if (Services.eidikotitesoles.get(j).get(i).getName().contains(t1[2])) {
						duration[0] = Services.eidikotitesoles.get(j).get(i).getDuration();
						duration[1] = Services.eidikotitesoles.get(j).get(i).getCost();
						break;
					}
				}
			}
		}
		return duration;
	}
		
	public static void basedOnDate(String[] t1, double[] duration, Table[][] calendar, String kat) { // BASED ON DATE
																							

		Random rand = new Random();
		int validcode = 0;
		String stringid = "";
		String stringvalidcode = "";
		String stringcode = "";
		String eidikotita = t1[1];
		String anstime = "ΑΛΛΟ";
		String[][] data = new String[16][2];
		String protasi = "no protasi";
		int day = 0;
		int month = 0;
		int existsnew = 0;
		double totalcells;
		int hours = 0;
		while ((anstime.toLowerCase().contains("ΑΛΛΟ")) || (existsnew == 0)) { // ψάχνω μέχρι να βρω διαθέσιμες ώρες ΚΑΙ
																				// μέχρι
																				// κάποια απο αυτές να βολεύει τον
																				// πελάτη
																				// μας
			String md[][] = new String[18][2];

			if (protasi.contains("ΠΡΟΤΑΣΗ")) { // A SUGGESTION

				md = suggestion(month, day, eidikotita, duration[0], calendar);
				day = Integer.parseInt(md[1][0]);
				month = Integer.parseInt(md[0][0]);
				for (int o = 2; o < 18; o++) {
					data[o - 2][0] = md[o][0];
					data[o - 2][1] = md[o][1];
				}

			} else { // NOT A SUGGESTION

				/*System.out.println("Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε!");*/
				JOptionPane.showMessageDialog(frame,"Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε!");
				/*System.out.println("Μήνας: ");
				month = m.nextInt();*/
				String mon=JOptionPane.showInputDialog(frame,"Μήνας:");
				month=Integer.parseInt(mon);
				/*System.out.println("Ημέρα: ");
				day = m.nextInt();*/
				String d=JOptionPane.showInputDialog(frame,"Ημέρα:");
                day=Integer.parseInt(d);
				data = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita, duration[0]);
			}
		

			for (int t = 1; t <= 16; t++) { // make sure that there's content in table data
				if (data[0][0].contains(calendar[month][day].getTable()[t][0])) {
					hours++;
					break;
				}
			}

			if (hours != 0) { // THERE ARE FREE HOURS

				/*System.out.println(
						"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα):");
				anstime = m.next();*/
				anstime=JOptionPane.showInputDialog(frame,"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα):");

				if (!(anstime.contains("ΑΛΛΟ"))) { // ONE OF THE AVAILABLE HOURS IS SELECTED

					for (int kk = 0; kk < 16; kk++) { // the real j(= doctor)
						int num = Integer.parseInt(anstime.substring(0, 1));
						int dat = Integer.parseInt(data[kk][0].substring(0, 1));
						if (num == dat) {
							existsnew = Integer.parseInt(data[kk][1]);
							break;
						}
					}

					for (int k = 1; k <= 16; k++) {

						if (duration[0] <= 30) {
							if (calendar[month][day].getTable()[k][0].contains(anstime)) {

								validcode = rand.nextInt(100000);
								stringvalidcode = String.valueOf(validcode);
								stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
								stringcode = stringvalidcode + stringid;
								calendar[month][day].getTable()[k][existsnew] = "  " + stringcode + "     ";
								break;
							}
						} else {
							totalcells = (duration[0] / 30);
							if (calendar[month][day].getTable()[k][0].contains(anstime)) {
								validcode = rand.nextInt(100000);
								for (int l = 0; l < totalcells; l++) {
									stringvalidcode = String.valueOf(validcode);
									stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
									stringcode = stringvalidcode + stringid;
									calendar[month][day].getTable()[k + l][existsnew] = "  " + stringcode + "     ";
								}
								break;
							}
						} 
					}
				} else { // NONE OF THE AVAILABLE HOURS IS SELECTED BY THE CLIENT
				   /*System.out.println("Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην \n"
							+ "σας βόλεψαν, παρακαλώ εισάγεται καινούρια στοιχεία για να σας εξυπηρετήσουμε ή αφήστε \n"
							+ "μας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες!  \n*ΝΕΑ ΕΙΣΑΓΩΓΗ\n*ΠΡΟΤΑΣΗ");
					protasi = m.next();*/
					protasi=JOptionPane.showInputDialog(frame,"Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην"
							                                   +"\r\n σας βόλεψαν, παρακαλώ εισάγεται καινούρια στοιχεία για να σας εξυπηρετήσουμε ή αφήστε"
							                                   +"\r\n μας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες.\nΕπιλέξτε:\nΝΕΑ ΕΙΣΑΓΩΓΗ\nΠΡΟΤΑΣΗ");
					existsnew = 0;
				}
			} else { // DID NOT FIND FREE HOURS
				/*System.out.println("Δεν βρήκαμε ελεύθερες ώρες για εσάς την συγκεκριμένη μέρα,\n "
						+ "αν επιθυμείτε επανεισάγετε τα στοιχεία για μία κανούρια ημερομηνία ή αφήστε μας να σας προτείνουμε\n "
						+ "ελεύθερες ώρες σε κοντινές ημερομηνίες!  \n*ΝΕΑ ΕΙΣΑΓΩΓΗ\n*ΠΡΟΤΑΣΗ");
				protasi = m.next();*/
				
				protasi=JOptionPane.showInputDialog(frame,"Δεν βρήκαμε ελεύθερες ώρες για εσάς την συγκεκριμένη μέρα,"
                        +"\r\n αν επιθυμείτε επανεισάγετε τα στοιχεία για μία κανούρια ημερομηνία ή αφήστε μας να σας προτείνουμε"
                        +"\r\n ελεύθερες ώρες σε κοντινές ημερομηνίες.\nΕπιλέξτε:\nΝΕΑ ΕΙΣΑΓΩΓΗ\nΠΡΟΤΑΣΗ");
				
			}
		}
		
		if (kat.contains("katachorish")) {
			/*System.out.println("-------------------------------------------------\n" + "Γεια σου "
					+ Client.clients.get(Client.numOfClients - 1).getName() + " "
					+ Client.clients.get(Client.numOfClients - 1).getSurname()
					+ "!\nΤο ραντεβού σου καταχωρήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα: " + anstime
					+ "\nΕξέταση: " + t1[2] + " (κατηγορία: " + t1[1] + ")\n" + "Κόστος: " + duration[1] + "$"
					+ "\nΚωδικός επιβεβαίωσης: " + stringvalidcode
					+ "\n-------------------------------------------------");
			*/
			JOptionPane.showMessageDialog(frame,"Γεια σου "+ Client.clients.get(Client.numOfClients - 1).getName()
                    +"  " + Client.clients.get(Client.numOfClients - 1).getSurname()
					+"\r\nΤο ραντεβού σου καταχωρήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα: " + anstime
					+"\r\nΕξέταση: " + t1[2] + " (κατηγορία: " + t1[1] + ")\n" + "Κόστος: " + duration[1] + "$"
					+ "\r\nΚωδικός επιβεβαίωσης: " + stringvalidcode);
			
			Menu.sumPlus(t1[1]);
		} else {
			/*System.out.println("-------------------------------------------------\n"
					+ "Το ραντεβού σας μετακινήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα: " + anstime
					+ "\nΟ καινούριος σας κωδικός επιβεβαίωσης: " + stringvalidcode
					+ "\n-------------------------------------------------");
			*/
			JOptionPane.showMessageDialog(frame,"Το ραντεβού σας μετακινήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα:" + anstime
                    +"\r\nΟ καινούριος σας κωδικός επιβεβαίωσης:" + stringvalidcode);
			Menu.sumPlus(t1[1]);
         }
	} 

	
	public static void basedOnDateAndEmp(String[] t1, double[] duration, String kat, String doc, Table[][] calendar) {
		// BASED ON DATE AND EMPLOYEE

		Random rand = new Random();
		int validcode = 0;
		String stringid = null;
		String stringvalidcode = null;
		String stringcode = null;
		String anstime = "ΑΛΛΟ";
		int exists = 0;
		String protasi = "no protasi";
		String eidikotita = t1[1];
		ArrayList<String> doc_names = new ArrayList<String>();
		doc_names = Employees.returnDocNames(eidikotita);
		int doc_num = doc_names.size();
		int day = 0;
		int month = 0;
		int md[] = new int[3];
		String doctor = null;
		int empid = 0;

		while ((anstime.contains("ΑΛΛΟ")) || (exists == 0)) { 
			
			if (!(protasi.contains("ΠΡΟΤΑΣΗ"))) {

				/*System.out.println("Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε!");
			
				System.out.println("Μήνας: ");
				month = m.nextInt();
				System.out.println("Ημέρα: ");
				day = m.nextInt(); */
            
				JOptionPane.showMessageDialog(frame,"Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε!");
				String mon=JOptionPane.showInputDialog(frame,"Μήνας: ");
				month=Integer.parseInt(mon);
				String da=JOptionPane.showInputDialog(frame,"Ημέρα: ");
				day=Integer.parseInt(da);
				
				if (kat.contains("katachorish")) {
					/*System.out.println("Επιλέξτε τον γιατρό που επιθυμείτε:");
					for (int d = 0; d < doc_num; d++) {
						System.out.println(doc_names.get(d));
					}
					m.nextLine();
					doctor = m.nextLine();*/
					
					StringBuilder text = new StringBuilder();
					text.append("Επιλέξτε τον γιατρό που επιθυμείτε:"+"\r\n");
					for (int d = 0; d < doc_num; d++) {
					     text.append(doc_names.get(d)+"\r\n");
					 }
				    doctor=JOptionPane.showInputDialog(frame,text.toString());
					
				} else {
					doctor = doc;
				}
                 
				for (int g = 0; g < Employees.employees.size(); g++) {
					if (Employees.employees.get(g).getEmp_name().contains(doctor)) {
						empid = g;
						break;
					}
				}

				exists = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita,
						duration[0], empid); // the doctor 
			} else {
				if (kat.contains("katachorish")) {
					/*System.out.println("Επιλέξτε τον γιατρό που επιθυμείτε:");
					for (int d = 0; d < doc_num; d++) {
						System.out.println(doc_names.get(d));
					}
					m.nextLine();
					doctor = m.nextLine();*/
					StringBuilder text = new StringBuilder();
					text.append("Επιλέξτε τον γιατρό που επιθυμείτε:"+"\r\n");
					for (int d = 0; d < doc_num; d++) {
					     text.append(doc_names.get(d)+"\r\n");
					 }
				    doctor=JOptionPane.showInputDialog(frame,text.toString());
				} else {
					doctor = doc;
				}

				for (int g = 0; g < Employees.employees.size(); g++) {
					if (Employees.employees.get(g).getEmp_name().equals(doctor)) {
						empid = g;
					}
				}
				md = suggestion(month, day, eidikotita, duration[0], empid, calendar);
				day = md[1];
				month = md[0];
				exists = md[2];
			}

			double totalcells = 0;

			if (exists != 0) { // THERE ARE FREE HOURS

				if (kat.contains("katachorish")) {
					/*System.out.println(
							"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)!");
					anstime = m.nextLine();*/
					anstime=JOptionPane.showInputDialog(frame,"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)!");
				} else {
					/*System.out.println(
							"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)!");
					m.nextLine();
					anstime = m.nextLine();*/
					anstime=JOptionPane.showInputDialog(frame,"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)!");
				}

				if (!(anstime.contains("ΑΛΛΟ"))) { // ONE OF THE AVAILABLE HOURS IS SELECTED

					for (int k = 1; k <= 16; k++) {

						if (duration[0] <= 30) {
							if (calendar[month][day].getTable()[k][0].contains(anstime)) {
								
								validcode = rand.nextInt(100000);
								stringvalidcode = String.valueOf(validcode);
								stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
								stringcode = stringvalidcode + stringid;
								calendar[month][day].getTable()[k][exists] = "   " + stringcode;
								break;
							}
						} else {
							totalcells = (duration[0] / 30);
							if (calendar[month][day].getTable()[k][0].contains(anstime)) {
								
								for (int l = 0; l < totalcells; l++) {
									validcode = rand.nextInt(100000);
									stringvalidcode = String.valueOf(validcode);
									stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
									stringcode = stringvalidcode + stringid;
									calendar[month][day].getTable()[k + l][exists] = "   " + stringcode;
								}
								break;
							}
						}
					}
				} else { // NONE OF THE AVAILABLE HOURS IS SELECTED BY THE CLIENT
					/*System.out.println("Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην "
							+ "\nσας βόλεψαν, παρακαλώ εισάγεται καινούρια στοιχεία για να σας \nεξυπηρετήσουμε ή αφήστε "
							+ "μας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες!   \n*ΝΕΑ ΕΙΣΑΓΩΓΗ\n*ΠΡΟΤΑΣΗ");
					protasi = m.next();*/
					
					protasi=JOptionPane.showInputDialog(frame,"Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην"
                            +"\r\nσας βόλεψαν, παρακαλώ εισάγεται καινούρια στοιχεία για να σας εξυπηρετήσουμε ή αφήστε"
                            +"\r\nμας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες.\nΕπιλέξτε:\nΝΕΑ ΕΙΣΑΓΩΓΗ\nΠΡΟΤΑΣΗ");
				}
			} else { // DID NOT FIND FREE HOURS 
				/*System.out.println(
						"Δεν βρήκαμε ελεύθερες ώρες για εσάς την συγκεκριμένη μέρα με τον συγκεκριμένο γιατρό\n, "
								+ "αν επιθυμείτε επανεισάγετε τα στοιχεία για μία κανούρια ημερομηνία ή \nαφήστε μας να σας προτείνουμε "
								+ "ελεύθερες ώρες σε κοντινές ημερομηνίες!   \n*ΝΕΑ ΕΙΣΑΓΩΓΗ\n*ΠΡΟΤΑΣΗ");
				protasi = m.next();*/
				protasi=JOptionPane.showInputDialog(frame,"Δεν βρήκαμε ελεύθερες ώρες για εσάς την συγκεκριμένη μέρα,"
                        +"\r\nαν επιθυμείτε επανεισάγετε τα στοιχεία για μία κανούρια ημερομηνία ή αφήστε μας να σας προτείνουμε"
                        +"\r\nελεύθερες ώρες σε κοντινές ημερομηνίες.\nΕπιλέξτε:\nΝΕΑ ΕΙΣΑΓΩΓΗ\nΠΡΟΤΑΣΗ");
			}
		}
		
		if (kat.contains("katachorish")) {
			/*System.out.println("-------------------------------------------------\n" + "Γεια σου "
					+ Client.clients.get(Client.numOfClients - 1).getName() + " "
					+ Client.clients.get(Client.numOfClients - 1).getSurname()
					+ "!\nΤο ραντεβού σου καταχωρήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα: " + anstime
					+ "\nΕξέταση: " + t1[2] + " (κατηγορία: " + t1[1] + ")\n" + "Κόστος: " + duration[1] + "$"
					+ "\nΙατρός: " + doctor + "\nΚωδικός επιβεβαίωσης: " + stringvalidcode
					+ "\n--------------------------------------------------");*/
			JOptionPane.showMessageDialog(frame,"Γεια σου "
					+ Client.clients.get(Client.numOfClients - 1).getName() + " "
					+ Client.clients.get(Client.numOfClients - 1).getSurname()
					+ "!\nΤο ραντεβού σου καταχωρήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα: " + anstime
					+ "\nΕξέταση: " + t1[2] + " (κατηγορία: " + t1[1] + ")\n" + "Κόστος: " + duration[1] + "$"
					+ "\nΙατρός: " + doctor + "\nΚωδικός επιβεβαίωσης: " + stringvalidcode);
			
			Menu.sumPlus(t1[1]);
		} else {
			/*System.out.println("-------------------------------------------------\n"
					+ "Το ραντεβού σας μετακινήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα: " + anstime
					+ "\nΟ καινούριος σας κωδικός επιβεβαίωσης: " + stringvalidcode
					+ "\n-------------------------------------------------");*/
			JOptionPane.showMessageDialog(frame,"Το ραντεβού σας μετακινήθηκε για τις " + day + "/" + month + "/2019\n" + "Ώρα:" + anstime
                    +"\r\n Ο καινούριος σας κωδικός επιβεβαίωσης:" + stringvalidcode);
			Menu.sumPlus(t1[1]);
		}
	}

	public static String[][] suggestion(int month, int day, String eidikotita, double duration, Table[][] calendar) { // BASED ON DATE
																														
		String[][] md = new String[18][2];
		int ex1 = 0;
		String data1[][] = new String[16][2];

		while (ex1 == 0) { // FIND THE NEXT'S DAY FREE HOURS 

			if (day == 30) {

				data1 = calendar[month + 1][1].checkingFreehours(calendar[month + 1][1].getTable(), eidikotita,
						duration);

				if (!(data1[0][0].equals(null))) { // check if there is available hours
					md[1][0] = "1";
					md[0][0] = String.valueOf(month + 1);
					ex1 = 1;
					JOptionPane.showMessageDialog(frame,"Αυτές είναι οι διαθέσιμες ώρες για " + md[1][0] + "/" + md[0][0] + "!");
					/*System.out.println();*/
				}
				day = 1;

			} else {

				data1 = calendar[month][day + 1].checkingFreehours(calendar[month][day + 1].getTable(), eidikotita,
						duration);
				
				if (!(data1[0][0].equals(null))) { // check if there is available hours
					md[1][0] = String.valueOf(day + 1);
					md[0][0] = String.valueOf(month);
					ex1 = 1;
					JOptionPane.showMessageDialog(frame,"Αυτές είναι οι διαθέσιμες ώρες για " + md[1][0] + "/" + md[0][0] + "!");
					/*System.out.println("Αυτές είναι οι διαθέσιμες ώρες για " + md[1][0] + "/" + md[0][0] + "!");
					System.out.println();*/
				}
				day = day + 1;
			}
		}
		md[0][1] = "0";
		md[1][1] = "0";
		for (int l = 2; l < 18; l++) {
			md[l][0] = data1[l - 2][0];
			md[l][1] = data1[l - 2][1];
		}
		return md;
	}
	
	public static int[] suggestion(int month, int day, String eidikotita, double duration, int empid,
			Table[][] calendar) { // BASED ON DATE AND EMPLOYEE

		int[] md = new int[3];
		int ex1 = 0;
		int d = 0;

		while (ex1 == 0) { // FIND THE NEXT'S DAY FREE HOURS 
			
			if (day == 30) {
				ex1 = calendar[month + 1][1].checkingFreehours(calendar[month + 1][1].getTable(), eidikotita, duration,
						empid);
				if (ex1 != 0) {
					
					md[1] = 1;
					md[0] = month + 1;
					JOptionPane.showMessageDialog(frame,"Αυτές είναι οι διαθέσιμες ώρες για " + md[1] + "/" + md[0] + "!");
				}
				day = 1;
				
			} else {
				ex1 = calendar[month][day + d + 1].checkingFreehours(calendar[month][day + d + 1].getTable(),
						eidikotita, duration, empid);
				
				if (ex1 != 0) {
					md[1] = day + d + 1;
					md[0] = month;
					JOptionPane.showMessageDialog(frame,"Αυτές είναι οι διαθέσιμες ώρες για " + md[1] + "/" + md[0] + "!");
					
				}
				day = day + 1;
			}
		}
		md[2] = ex1;
		return md;
	}

}
