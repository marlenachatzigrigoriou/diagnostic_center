/**
 * 
 */
package ergasia2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author HP
 *
 */
public class Menu {

	static Scanner v = new Scanner(System.in);

	public static String chooseService() {
		System.out.println("Παρακαλώ επιλέξτε υπηρεσία \n------------------------------");
		Services.listEidikotites();
		for (int i = 0; i < 22; i++) {
			// System.out.println(Services.eidikotitesoles.get(i).get(0).getCategory());
			System.out.println(Services.eidikotites.get(i));
		}
		String eidikotita = v.nextLine();
		return eidikotita;
	}

	public static String chooseCriterion() {
		boolean ok = false;
		String ans = null;
		while (ok == false) {

			try {
				System.out.println("Παρακαλώ επιλέξτε με τι κριτήρια θέλετε να γίνει η καταχώρηση του ραντεβού");
				System.out.println(" 1.Βάση Ημερομηνίας \n 2.Βάση γιατρού και ημερομηνίας");
				ans = wannabeMain.in.next();
				ok = true;

			} catch (InputMismatchException e) {

				System.out.println("insert the number of month and day.");
			}

		}
		return ans;
	}

	public static boolean filterAndPrintServices(String search, String eidikotita) { // έχει την επιλογή να αναζητήσει
																						// μόνος του
																						// τις επιμέρους
																						// εξετάσεις-υπηρεσίες

		// eidikotita = εκείνη η κατηγορία εξετάσεων που επέλεξε ο πελάτης
		boolean flag = true;
		boolean exists = false;
		String exetasi_se_lista;// το όνομα της επιμέρους εξέτασης που βρίσκεται στα αρχεία μας
		ArrayList<String> exetaseis_list = new ArrayList<String>(); // οι απαντήσεις του προγράμματος σε σχέση με την
																	// αναζήτηση του πελάτη
		if (search.contains("ΟΛΕΣ")) {

			for (int a = 0; a < 22; a++) {
				if (eidikotita.toLowerCase().contains(Services.eidikotites.get(a))) {

					int size = Services.eidikotitesoles.get(a).size();

					for (int i = 0; i < size; i++) {
						System.out.println(Services.eidikotitesoles.get(a).get(i).getName());
						exists = true;
					}
					break;
				}

			}

		} else {
			for (int y = 0; y < 22; y++) {

				if (eidikotita.toLowerCase().contains(Services.eidikotites.get(y))) {

					for (int i = 0; i < Services.eidikotitesoles.get(y).size(); i++) {
						exetasi_se_lista = Services.eidikotitesoles.get(y).get(i).getName();

						if (exetasi_se_lista.toLowerCase().contains(search.toLowerCase())) {
							exetaseis_list.add(exetasi_se_lista);
							exists = true;
						}
					}
					if (exists == false) {
						System.out.println("Δεν υπάρχει τέτοια εξέταση");
						flag = false;
					} else {
						System.out.println("Επιλέξτε την εξέταση που επιθυμείτε");
						for (int k = 0; k < exetaseis_list.size(); k++) {
							System.out.println(exetaseis_list.get(k));
						}
					}

					break; // βρήκες την κατηγορία των εξετάσεων που επιθυμεί να κάνει, άρα φεύγες απο το
							// for που
							// ψάχνει στα ονόματα κατηγοριών
				}
			}
		}
		return flag;
	}

}
