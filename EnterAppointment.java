package ergasia2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class EnterAppointment {

	static Scanner m = new Scanner(System.in);

	public static String[] questionsToBegin() {

		String[] t1 = new String[3];
		boolean found = false;
		String search = null;

		String eidikotita = Menu.chooseService(); // διαλέγει ειδικότητα
		t1[1] = eidikotita;
		System.out.println("Αναζήτηση");
		boolean inserted = false;

		while (inserted == false) {
			try {
				search = m.nextLine();// πληκτρολογεί στην αναζήτηση
				inserted = true;
			} catch (InputMismatchException e) {
				System.out.println("insert the required info.");
			}
		}

		do {
			if (Menu.filterAndPrintServices(search, eidikotita) == false) {
				System.out.println("Είστε βέβαιοι ότι επιθυμείτε την υπηρεσία: " + eidikotita + ";");
				String a = null;
				boolean correct = false;

				while (correct == false) {
					try {
						a = m.next();
						correct = true;
					} catch (InputMismatchException e) {
						System.out.println("εισαγετε ναι ή οχι.");
					}
				}

				correct = false;

				while (correct == false) {
					try {
						if (a.contains("ναι")) {
							System.out.println("Αναζήτηση");
							search = m.nextLine();// πληκτρολογεί στην αναζήτηση
							correct = true;
						} else {
							eidikotita = Menu.chooseService(); // διαλέγει ειδικότητα
							t1[1] = eidikotita;
							System.out.println("Αναζήτηση");
							search = m.nextLine();
							correct = true;
						}
					} catch (InputMismatchException e) {
						System.out.println("insert the required info.");
					}
				}

			} else {
				found = true;
			}
		} while (!found);

		// βγαίνει λίστα με τα αποτελέσματα
		// της αναζήτησης του
		//m.nextLine();
		String choice = null;
		boolean correct = false;

		while (correct == false) {
			try {
				choice = m.nextLine();// διαβάζουμε τη τελική του επιλογή υπηρεσίας
				correct = true;

			} catch (InputMismatchException e) {
				System.out.println("insert the required info.");
			}
		}

		t1[2] = choice;

		String ans = Menu.chooseCriterion(); // διαβάζουμε το κρητίριο
		t1[0] = ans;
		return t1;
	}

	public static double [] choiceDuration(String[] t1) {


		double duration [] = new double[2];

		for (int j = 0; j < 22; j++) {
			
			if (t1[1].toLowerCase().contains(Services.eidikotites.get(j))) {
				
				for (int i = 0; i < Services.eidikotitesoles.get(j).size(); i++) {
					//System.out.println(Services.eidikotitesoles.get(j).get(i).getName());
					//System.out.println(t1[2]);
					//boolean b = Services.eidikotitesoles.get(j).get(i).getName().contains(t1[2]);
					//System.out.println(b);
					if (Services.eidikotitesoles.get(j).get(i).getName().contains(t1[2])) {
						//System.out.println("wsdcsaxc");
						duration[0] = Services.eidikotitesoles.get(j).get(i).getDuration();
						duration[1] = Services.eidikotitesoles.get(j).get(i).getCost();
						//System.out.println(duration[0] + "+"  + duration[1]);
						break;
					}
				}
			}
		}
		return duration;
	}

	public static void basedOnDate(String[] t1, double [] duration, Table[][] calendar) { // ΒΑΣΗ ΗΜΕΡΟΜΗΝΙΑΣ--> ans == "1"
		Random rand = new Random();
		int validcode = 0;
		String stringid = null;
		String stringvalidcode = null;
		String stringcode = null;
		String eidikotita = t1[1];
		String anstime = "ΑΛΛΟ";
		int exists = 0;
		String protasi = "no protasi";
		int day = 0;
		int month = 0;

		while ((anstime.toLowerCase().contains("ΑΛΛΟ")) || (exists == 0)) { // ψάχνω μέχρι να βρω διαθέσιμες ώρες ΚΑΙ
																			// μέχρι
																			// κάποια απο αυτές να βολεύει τον πελάτη
																			// μας
			int md[] = new int[3];
			if (protasi.contains("ΠΡΟΤΑΣΗ")) {
				md = suggestion(month, day, eidikotita, duration[0], calendar);
				day = md[1];
				month = md[0];
				exists = md[2];
			} else {
				System.out.println("Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε");
				System.out.println("Μήνας: ");
				boolean ok2 = false;

				while (ok2 == false) {// each variable checks if month and day are inserted correctly
					try {
						month = m.nextInt();
						System.out.println("Ημέρα: ");
						day = m.nextInt();
						ok2 = true;
					} catch (InputMismatchException e) {
						System.out.println("insert the required info.");
					}
				}

				try {
					exists = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita,
							duration[0]);
					System.out.println(exists);
					System.out.println(duration[0]);
					// πέρνουμε ειδικότητα και όχι τελική επιλογή= υπηρεσία γιατι τσεκάρω βάση κενών
					// των γιατρων
					// ένας γιατρος με σπεσιαλτι = αιματολ μπορει να κάνει ολες τις αιματολ.
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("error in array's bounds.");
				}
			}
			double totalcells;

			if (exists != 0) { // υπάρχουν κενές ώρες

				System.out.println(
						"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)");
				boolean correct = false;

				while (correct == false) {
					try {
						anstime = m.next();
						correct = true;
					} catch (InputMismatchException e) {
						System.out.println("insert the required info.");
					}
				}

				if (!(anstime.contains("ΑΛΛΟ"))) { // τον βολεύει κάποια απο τις ώρες μας

					for (int k = 1; k <= 16; k++) {

						if (duration[0] <= 30) {

							try {
								if (calendar[month][day].getTable()[k][0].contains(anstime)) {

									validcode = rand.nextInt(100000);
									stringvalidcode = String.valueOf(validcode);
									stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
									stringcode = stringvalidcode + stringid;
									calendar[month][day].getTable()[k][exists] = "  " + stringcode + "     ";
									break;
								}
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("error in array's bounds.");
							}
						} else {
							totalcells = (duration[0] / 30);

							try {
								if (calendar[month][day].getTable()[k][0].contains(anstime)) {
									validcode = rand.nextInt(100000);
									int ip = 0;
									if ((duration[0] % 30) == 0) {
										ip = 0;
									} else {
										ip = 1;
									}
									for (int l = 0; l < (totalcells + ip); l++) {
										stringvalidcode = String.valueOf(validcode);
										stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
										stringcode = stringvalidcode + stringid;
										calendar[month][day].getTable()[k + l][exists] = "  " + stringcode + "     ";
									}
									break;
								}
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("error in array's bounds.");
							}
						} // όταν το ραντεβού κρατάει πάνω απο μισή ώρα συμπληρώνω με τα στοιχεία του
							// πελάτη όλα τα απαραίτητα κελιά του τέιμπλ

					}
				} else { // ενώ έχουμε κενό εκείνη την μέρα δεν τον βολεύει κάποια ώρα --> άρα ξανα
							// τρέχτο
					System.out.println("Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην \n"
							+ "σας βόλεψαν, παρακαλώ εισάγετε καινούρια στοιχεία για να σας εξυπηρετήσουμε ή αφήστε \n"
							+ "μας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες.\n ΠΡΟΤΑΣΗ ή ΕΚ ΝΕΟΥ ΗΜΕΡΟΜΗΝΙΑ.");

					correct = false;

					while (correct == false) {
						try {
							protasi = m.next();
							correct = true;
						} catch (InputMismatchException e) {
							System.out.println("insert the required info.");
						}
					}
					exists = 0;
					// anstime = "1";
				}
				// μπαινω στον συγκεκριμένο table που διαλεξε ο πελάτης και συμπληρώνω στο κελι
				// -με ώρα
				// k και γιατρο τον πρώτο που βρίσκει απο την checkingFreehours δλδ τον exists-
				// την toString
				// του πελάτη μου, τον οποίο θα τον βρίσκω απο το numOfClients -1 κάθε φορά

			} else { // δε έχει κανένα κενό εκείνη την μέρα (exists == 0) --> άρα ξανα τρέχτο
				System.out.println("Δεν βρήκαμε ελεύθερες ώρες για εσάς την συγκεκριμένη μέρα,\n "
						+ "αν επιθυμείτε επανεισάγετε τα στοιχεία για μία κανούρια ημερομηνία ή αφήστε μας να σας προτείνουμε\n "
						+ "ελεύθερες ώρες σε κοντινές ημερομηνίες\n ΠΡΟΤΑΣΗ ή ΝΕΑ ΗΜΕΡΟΜΗΝΙΑ");

				boolean correct = false;

				while (correct == false) {
					try {
						protasi = m.next();
						correct = true;
					} catch (InputMismatchException e) {
						System.out.println("insert the required info.");
					}
				}

			}
		}
		System.out.println(duration[0] + "   " + duration[1]);
		System.out.println("Γεια σου " + Client.clients.get(Client.numOfClients - 1).getName() + " "
				+ Client.clients.get(Client.numOfClients - 1).getSurname() + "!\nΤο ραντεβού σου καταχωρήθηκε για τις "
				+ day + "/" + month + "/2019\n" + "Ώρα: " + anstime + "\n" + "Εξέταση: " + t1[2] + " (κατηγορία: "
				+ t1[1] + ")\n" + "Κόστος: " + duration[1] + "$" + "\n" + "Κωδικός επιβεβαίωσης: " + stringvalidcode);
	}
	
	// kat= "katachorish", doc = null --> για την αρχική καταχώρηση
	// η ίδια μέθοδος χρησιμοποιείται και στην αλλαγή ραντεβού, και ανάλογα αν έχω
	// αλλαγή και καταχώρηση εκ νεόυ κάποιων στοιχειων
	// ή αρχική καταχώρηση εκετλούνται διαφορετικά τμήματα της μεθόδου

	public static void basedOnDateAndEmp(String[] t1, double [] duration, String kat, String doc, Table[][] calendar) {
		// ΒΑΣΗ ΚΑΙ ΓΙΑΤΡΟΥ--> ans == "2"

		Random rand = new Random();
		int validcode = 0;
		String stringid = null;
		String stringvalidcode = null;
		String stringcode = null;
		String anstime = " ΑΛΛΟ ";
		int exists = 0;
		String protasi = "οχι";
		String eidikotita = t1[1];
		ArrayList<String> doc_names = new ArrayList<String>();
		doc_names = Employees.returnDocNames(eidikotita);
		int doc_num = doc_names.size();
		int day = 0;
		int month = 0;
		int md[] = new int[3];
		String doctor = null;

		while ((anstime == " ΑΛΛΟ ") || (exists == 0)) { // ψάχνω μέχρι να βρω διαθέσιμες ώρες ΚΑΙ μέχρι
															// κάποια απο αυτές να βολεύει τον πελάτη μας

			if (!(protasi.equals("ΠΡΟΤΑΣΗ"))) {
				System.out.println("Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε");

				boolean ok1 = true;

				while (ok1) {

					try {
						System.out.println("Μήνας: ");
						month = m.nextInt();
						System.out.println("Ημέρα: ");
						day = m.nextInt();
						ok1 = false;
					} catch (InputMismatchException e) {
						System.out.println("insert the required info.");
					}
				}

				if (kat == "katachorish") {
					System.out.println("επιλέξτε τον γιατρό που επιθυμείτε:");
					for (int d = 0; d < doc_num; d++) {
						System.out.println(doc_names.get(d));
					}
					wannabeMain.in.nextLine();
					doctor = wannabeMain.in.nextLine();

				} else {
					doctor = doc;
				}

				
					exists = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita,
							duration[0], doctor); // η θέση του γιατρού
				
			} else {
				if (kat == "katachorish") {
					System.out.println("Επιλέξτε τον γιατρό που επιθυμείτε");
					for (int iii = 0; iii < Employees.employees.size(); iii++) {
						System.out.println(Employees.employees.get(iii));
					}
					doctor = wannabeMain.in.nextLine();

				} else {
					doctor = doc;
				}
				md = suggestion(month, day, eidikotita, duration[0], doctor, calendar);
				day = md[1];
				month = md[0];
				exists = md[2];
			}

			double totalcells = 0;

			if (exists != 0) { // ΒΡΗΚΑ ΚΕΝΕΣ ΩΡΕΣ
				System.out.println(
						"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)");
				boolean correct = false;
				while (correct == false) {
					try {
						anstime = m.nextLine();
						correct = true;
					} catch (InputMismatchException e) {
						System.out.println("insert the required info.");
					}
				}

				if (anstime != "ΑΛΛΟ") { // τον βολεύει κάποια απο τις ώρες μας

					for (int k = 1; k <= 16; k++) {

						if (duration[0] <= 30) {

							try {
								if (calendar[month][day].getTable()[k][0] == anstime) {
									validcode = rand.nextInt(100000);
									stringvalidcode = String.valueOf(validcode);
									stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
									stringcode = stringvalidcode + stringid;
									calendar[month][day].getTable()[k][exists] = "   " + stringcode;
									break;
								}
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("error in array's bounds.");
							}

						} else {// όταν το ραντεβού κρατάει πάνω απο μισή ώρα συμπληρώνω με τα στοιχεία του
								// πελάτη όλα τα απαραίτητα κελιά του τέιμπλ
							totalcells = (duration[0] / 30);

							try {
								if (calendar[month][day].getTable()[k][0] == anstime) {
									int ip = 0;
									if ((duration[0] % 30) == 0) {
										ip = 0;
									} else {
										ip = 1;
									}
									for (int l = 0; l < (totalcells + ip); l++) {
										validcode = rand.nextInt(100000);
										stringvalidcode = String.valueOf(validcode);
										stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
										stringcode = stringvalidcode + stringid;
										calendar[month][day].getTable()[k + l][exists] = "   " + stringcode;
									}
									break;
								}
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("error in array's bounds.");
							}
						}
					}
				} else { // δεν τον βολεύει κάποια ώρα απο αυτές που βρήκα --> άρα ξανα τρέχτο
					System.out.println("Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην "
							+ "σας βόλεψαν, παρακαλώ εισάγετε καινούρια στοιχεία για να σας εξυπηρετήσουμε ή αφήστε "
							+ "μας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες!\n ΠΡΟΤΑΣΗ ή ΝΕΑ ΗΜΕΡΟΜΗΝΙΑ ");

					correct = false;
					while (correct == false) {
						try {
							protasi = m.next();
							correct = true;
						} catch (InputMismatchException e) {
							System.out.println("insert the required info.");
						}
					}
				}
			} else { // ΔΕΝ ΒΡΗΚΑ ΚΕΝΕΣ ΩΡΕΣ --> ξανα τρέχτο
				System.out.println(
						"Δεν βρήκαμε ελεύθερες ώρες για εσάς την συγκεκριμένη μέρα με τον συγκεκριμένο γιατρό, "
								+ "αν επιθυμείτε επανεισάγετε τα στοιχεία για μία κανούρια ημερομηνία ή αφήστε μας να σας προτείνουμε "
								+ "ελεύθερες ώρες σε κοντινές ημερομηνίες!\n ΠΡΟΤΑΣΗ ή ΝΕΑ ΗΜΕΡΟΜΗΝΙΑ ");

				boolean correct = false;
				while (correct == false) {
					try {
						protasi = m.next();
						correct = true;
					} catch (InputMismatchException e) {
						System.out.println("insert the required info.");
					}
				}

			}
		}
		System.out.println("Γεια σου " + Client.clients.get(Client.numOfClients - 1).getName() + " "
				+ Client.clients.get(Client.numOfClients - 1).getSurname() + "!\nΤο ραντεβού σου καταχωρήθηκε για τις "
				+ day + "/" + month + "/2019\n" + "Ώρα: " + anstime + "\n" + "Εξέταση: " + t1[2] + " (κατηγορία: " + t1[1] + ")\n" + "Ιατρός: "
				+ doctor + "Κόστος: " + duration[1] + "\n" + "\nΚωδικός επιβεβαίωσης: " + stringvalidcode);

	}

	public static int[] suggestion(int month, int day, String eidikotita, double duration, Table[][] calendar) { // ANS = 1

		int[] md = new int[3];
		int ex1 = 0;
		int d = 0;
		while (ex1 == 0) { // ΒΡΙΣΚΕΙ ΓΙΑ 1 ΜΕΡΑ ΜΕΤΑ ΚΕΝΕΣ ΩΡΕΣ

			//try {
				if (day == 30) {
					ex1 = calendar[month + 1][1].checkingFreehours(calendar[month + 1][1].getTable(),
							eidikotita, duration);
					if (ex1 != 0) {
						md[1] = 1;
						md[0] = month + 1;
						System.out.println("Αυτές είναι οι διαθέσιμες ώρες για " + md[1] + "/" + md[0]);
					}
					day = 1;
				
				} else {
					ex1 = calendar[month][day + d + 1].checkingFreehours(calendar[month][day + d + 1].getTable(),
							eidikotita, duration);
					
					day = day + d + 1;
					if (ex1 != 0) {
						md[1] = day;
						md[0] = month;
						System.out.println("Αυτές είναι οι διαθέσιμες ώρες για " + md[1] + "/" + md[0]);
					}
				}
			//} catch (ArrayIndexOutOfBoundsException e) {
				//System.out.println("error in array's bounds");
			//}

			d++;
		
		}

		md[2] = ex1;
		return md; // απλώς θα μας δίνει την μέρα και τον μήνα της ημερομηνίας που του προτείναμε
					// και πάμε στην βασική μέθοδο και τα χρησιμοποιούμε κατευθείαν χωρίς να κάνουμε
					// ερωτήσεις για μέρα και μήνα κλπ.
	}

	public static int[] suggestion(int month, int day, String eidikotita, double duration, String doctor,
			Table[][] calendar) { // ANS = 2

		int[] md = new int[3];
		int ex1 = 0;
		int d = 0;

		while (ex1 == 0) { // ΒΡΙΣΚΕΙ ΓΙΑ 1 ΜΕΡΑ ΜΕΤΑ ΚΕΝΕΣ ΩΡΕΣ

			try {
				if (day == 30) {
					ex1 = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita, duration,
							doctor);
					if (ex1 != 0) {
						md[1] = 1 + d;
						md[0] = month + 1;
					}
				} else {
					ex1 = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita, duration,
							doctor);
					if (ex1 != 0) {
						md[1] = day + d + 1;
						md[0] = month;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("error in array's bounds.");
			}

			d++;
		}
		md[2] = ex1;

		return md;

	}

}