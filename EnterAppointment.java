package ergasia2;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EnterAppointment {

	static Scanner m = new Scanner(System.in);

	public static String[] questionsToBegin() {

		String[] t1 = new String[3];
		boolean found = false;

		String eidikotita = Menu.chooseService(); // διαλέγει ειδικότητα
		t1[1] = eidikotita;
		System.out.println("Αναζήτηση");
		String search = m.next();// πληκτρολογεί στην αναζήτηση
		do {
			if (Menu.filterAndPrintServices(search, eidikotita) == false) {
				System.out.println("Είστε βέβαιοι ότι επιθυμείτε την υπηρεσία: " + eidikotita + ";");
				String a = m.next();
				if (a.contains("ναι")) {
					System.out.println("Αναζήτηση");
					search = m.next();// πληκτρολογεί στην αναζήτηση
				} else {
					eidikotita = Menu.chooseService(); // διαλέγει ειδικότητα
					t1[1] = eidikotita;
					System.out.println("Αναζήτηση");
					search = m.next();
				}

			} else {
				found = true;
			}
		} while (!found);

		// βγαίνει λίστα με τα αποτελέσματα
		// της αναζήτησης του
		m.nextLine();
		String choice = m.nextLine();// διαβάζουμε τη τελική του επιλογή υπηρεσίας
		t1[2] = choice;

		String ans = Menu.chooseCriterion(); // διαβάζουμε το κρητίριο
		t1[0] = ans;
		return t1;
	}

	
	public static int choiceDuration(String[] t1) {

		int duration = 0;

		for (int j = 0; j < 22; j++) {

			if (t1[1].toLowerCase().contains(Services.eidikotites.get(j))) {

				for (int i = 0; i < Services.eidikotitesoles.get(j).size(); i++) {

					if (Services.eidikotitesoles.get(j).get(i).getName().toLowerCase().contains(t1[2])) {
						duration = Services.eidikotitesoles.get(j).get(i).getDuration();
						break;
					}
				}
			}
		}
		return duration;
	}
		
	public static void basedOnDate(String[] t1, int duration, Table[][] calendar) { // ΒΑΣΗ ΗΜΕΡΟΜΗΝΙΑΣ--> ans == "1"

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
				md = suggestion(month, day, eidikotita, duration, calendar);
				day = md[1];
				month = md[0];
				exists = md[2];
			} else {
				System.out.println("Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε");
				System.out.println("Μήνας: ");
				month = m.nextInt();
				System.out.println("Ημέρα: ");
				day = m.nextInt();

				exists = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita, duration);
				// πέρνουμε ειδικότητα και όχι τελική επιλογή= υπηρεσία γιατι τσεκάρω βάση κενών
				// των γιατρων
				// ένας γιατρος με σπεσιαλτι = αιματολ μπορει να κάνει ολες τις αιματολ.
			}
			int totalcells;

			if (exists != 0) { // υπάρχουν κενές ώρες

				System.out.println(
						"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)");
				anstime = m.next();

				if (!(anstime.contains("ΑΛΛΟ"))) { // τον βολεύει κάποια απο τις ώρες μας

					for (int k = 1; k <= 16; k++) {

						if (duration <= 30) {

							if (calendar[month][day].getTable()[k][0].contains(anstime)) {

								validcode = rand.nextInt(100000);
								stringvalidcode = String.valueOf(validcode);
								stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
								stringcode = stringvalidcode + stringid;
								calendar[month][day].getTable()[k][exists] = "  " + stringcode + "     ";
								break;
							}
						} else {
							totalcells = (duration / 30);
							if (calendar[month][day].getTable()[k][0].contains(anstime)) {
								validcode = rand.nextInt(100000);
								int ip = 0;
								if ((duration % 30) == 0) {
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
						}   // όταν το ραντεβού κρατάει πάνω απο μισή ώρα συμπληρώνω με τα στοιχεία του
							// πελάτη όλα τα απαραίτητα κελιά του τέιμπλ
					}
				} else { // ενώ έχουμε κενό εκείνη την μέρα δεν τον βολεύει κάποια ώρα --> άρα ξανα
							// τρέχτο
					System.out.println("Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην \n"
							+ "σας βόλεψαν, παρακαλώ εισάγεται καινούρια στοιχεία για να σας εξυπηρετήσουμε ή αφήστε \n"
							+ "μας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες");
					protasi = m.next();
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
						+ "ελεύθερες ώρες σε κοντινές ημερομηνίες!");
				protasi = m.next();
			}
		}
		System.out.println("Γεια σου " + Client.clients.get(Client.numOfClients - 1).getName() + " "
				+ Client.clients.get(Client.numOfClients - 1).getSurname() + "!\nΤο ραντεβού σου καταχωρήθηκε για τις "
				+ day + "/" + month + "/2019\n" + "Εξέταση: " + t1[2] + " (κατηγορία: " + t1[1] + ")\n"
				+ "Κωδικός επιβεβαίωσης: " + stringvalidcode);
	}
	

	// kat= "katachorish", doc = null  --> για την αρχική καταχώρηση
	// η ίδια μέθοδος χρησιμοποιείται και στην αλλαγή ραντεβού, και ανάλογα αν έχω αλλαγή και καταχώρηση εκ νεόυ κάποιων στοιχειων
	// ή αρχική καταχώρηση εκετλούνται διαφορετικά τμήματα της μεθόδου 
	
	public static void basedOnDateAndEmp(String[] t1, int duration, String kat, String doc, Table[][] calendar) {   
		// ΒΑΣΗ  ΚΑΙ ΓΙΑΤΡΟΥ--> ans == "2"

		Random rand = new Random();
		int validcode = 0;
		String stringid = null;
		String stringvalidcode = null;
		String stringcode = null;
		String anstime = " ΑΛΛΟ ";
		int exists = 0;
		String protasi = null;
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

			if (protasi != "ΠΡΟΤΑΣΗ") {
				System.out.println("Παρακαλώ εισάγετε την ημερομηνία που επιθυμείτε");
				System.out.println("Μήνας: ");
				month = m.nextInt();
				System.out.println("Ημέρα: ");
				day = m.nextInt();

				if (kat == "katachorish") {
					System.out.println("Τώρα επιλέξτε τον γιατρό που επιθυμείτε");
					for (int d = 0; d <= doc_num; d++) {
						System.out.println(doc_names.get(d));
					}
					doctor = m.nextLine();
				} else {
					doctor = doc;
				}

				exists = calendar[month][day].checkingFreehours(calendar[month][day].getTable(), eidikotita, duration,
						doctor); // η θέση του γιατρού

			} else {
				if (kat == "katachorish") {
					System.out.println("Επιλέξτε τον γιατρό που επιθυμείτε");
					doctor = m.nextLine();
				} else {
					doctor = doc;
				}
				md = suggestion(month, day, eidikotita, duration, doctor, calendar);
				day = md[1];
				month = md[0];
				exists = md[2];
			}

			int totalcells = 0;

			if (exists != 0) { // ΒΡΗΚΑ ΚΕΝΕΣ ΩΡΕΣ
				System.out.println(
						"Διαλέξτε την ώρα που επιθυμείτε (επιλέξτε ΑΛΛΟ αν δεν σας βολεύει καμία διαθέσιμη ώρα)");
				anstime = m.nextLine();

				if (anstime != "ΑΛΛΟ") { // τον βολεύει κάποια απο τις ώρες μας

					for (int k = 1; k <= 16; k++) {

						if (duration <= 30) {
							if (calendar[month][day].getTable()[k][0] == anstime) {
								validcode = rand.nextInt(100000);
								stringvalidcode = String.valueOf(validcode);
								stringid = String.valueOf(Client.clients.get(Client.numOfClients - 1).getId());
								stringcode = stringvalidcode + stringid;
								calendar[month][day].getTable()[k][exists] = "   " + stringcode;
								break;
							}
						} else {// όταν το ραντεβού κρατάει πάνω απο μισή ώρα συμπληρώνω με τα στοιχεία του
								// πελάτη όλα τα απαραίτητα κελιά του τέιμπλ
							totalcells = (duration / 30);
							if (calendar[month][day].getTable()[k][0] == anstime) {
								int ip = 0;
								if ((duration % 30) == 0) {
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
						}
					}
				} else { // δεν τον βολεύει κάποια ώρα απο αυτές που βρήκα --> άρα ξανα τρέχτο
					System.out.println("Καταλαβαίνουμε ότι οι διαθέσιμες ώρες μας μπορεί να μην "
							+ "σας βόλεψαν, παρακαλώ εισάγεται καινούρια στοιχεία για να σας εξυπηρετήσουμε ή αφήστε "
							+ "μας να σας προτείνουμε ελεύθερες ώρες σε κοντινές ημερομηνίες! ");
					protasi = m.next();
				}
			} else { // ΔΕΝ ΒΡΗΚΑ ΚΕΝΕΣ ΩΡΕΣ --> ξανα τρέχτο
				System.out.println(
						"Δεν βρήκαμε ελεύθερες ώρες για εσάς την συγκεκριμένη μέρα με τον συγκεκριμένο γιατρό, "
								+ "αν επιθυμείτε επανεισάγετε τα στοιχεία για μία κανούρια ημερομηνία ή αφήστε μας να σας προτείνουμε "
								+ "ελεύθερες ώρες σε κοντινές ημερομηνίες! ");
				protasi = m.next();
			}
		}
		System.out.println("Γεια σου " + Client.clients.get(Client.numOfClients - 1).getName() + " "
				+ Client.clients.get(Client.numOfClients - 1).getSurname() + "!\nΤο ραντεβού σου καταχωρήθηκε για τις "
				+ day + "/" + month + "/2019\n" + "Εξέταση: " + t1[2] + " (κατηγορία: " + t1[1] + ")\n" + "Ιατρός: "
				+ doctor + "\nΚωδικός επιβεβαίωσης: " + stringvalidcode);

	}
	
	public static int[] suggestion(int month, int day, String eidikotita, int duration, Table[][] calendar) { // ANS = 1

		int[] md = new int[3];
		int ex1 = 0;
		int d = 0;
		while (ex1 == 0) { // ΒΡΙΣΚΕΙ ΓΙΑ 1 ΜΕΡΑ ΜΕΤΑ ΚΕΝΕΣ ΩΡΕΣ
			if (day == 30) {
				ex1 = calendar[month + 1][1 + d].checkingFreehours(calendar[month + 1][1 + d].getTable(), eidikotita,
						duration);
				if (ex1 != 0) {
					md[1] = 1 + d;
					md[0] = month + 1;
					System.out.println("Αυτές είναι οι διαθέσιμες ώρες για " + md[1] + "/" + md[0]);
				}
			} else {
				ex1 = calendar[month][day + d + 1].checkingFreehours(calendar[month][day + d + 1].getTable(),
						eidikotita, duration);
				if (ex1 != 0) {
					md[1] = day + d + 1;
					md[0] = month;
					System.out.println("Αυτές είναι οι διαθέσιμες ώρες για " + md[1] + "/" + md[0]);
				}
			}
			d++;
		}
		md[2] = ex1;
		return md; // απλώς θα μας δίνει την μέρα και τον μήνα της ημερομηνίας που του προτείναμε
					// και πάμε στην βασική μέθοδο και τα χρησιμοποιούμε κατευθείαν χωρίς να κάνουμε
					// ερωτήσεις για μέρα και μήνα κλπ.
	}
	
	public static int[] suggestion(int month, int day, String eidikotita, int duration, String doctor,
			Table[][] calendar) { // ANS = 2

		int[] md = new int[3];
		int ex1 = 0;
		int d = 0;

		while (ex1 == 0) { // ΒΡΙΣΚΕΙ ΓΙΑ 1 ΜΕΡΑ ΜΕΤΑ ΚΕΝΕΣ ΩΡΕΣ
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
			d++;
		}
		md[2] = ex1;

		return md;

	}
	
	
	

}