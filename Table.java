/**
 * 
 */
package ergasia2;

/**
 * @author HP
 *
 */
public class Table {

	private String table[][] = new String[17][Employees.employees.size() + 2];  // κάθε αντικείμενο τύπου Table έχει
																				// πεδίο έναν πίνακα table

	public Table() {

		table[0][0] = null;
		for (int i = 0; i < Employees.employees.size(); i++) { // θα έχει τόσες στήλες όσοι είνα κ οι γιατροί
			table[0][i + 1] = Employees.employees.get(i).getEmp_name();
		}

		table[1][0] = "9:00 ";
		table[2][0] = "9:30 ";
		table[3][0] = "10:00";
		table[4][0] = "10:30";
		table[5][0] = "11:00";  // και οι στήλες και οι γραμμές θα ξεκινάνε απο την 1 όχι απο την 0 στήλη κ
							    // γραμμή αντίστοιχα ΔΛΔ:
		table[6][0] = "11:30";  // null  ON1 ON2 ON3 ON4 ...
		table[7][0] = "12:00";  // 9:00  OXI OXI OXI OXI ...
		table[8][0] = "12:30";  // 9:30  OXI OXI OXI OXI ...
		table[9][0] = "13:00";  // 10:00 OXI OXI OXI OXI ...
		table[10][0] = "13:30"; // 10:30 OXI OXI OXI OXI ...
		table[11][0] = "14:00";
		table[12][0] = "14:30";
		table[13][0] = "15:00";
		table[14][0] = "15:30";
		table[15][0] = "16:00";
		table[16][0] = "16:30";

		for (int i = 1; i <= 16; i++) {
			for (int j = 1; j <= Employees.employees.size(); j++) {
				table[i][j] = "         ΟΧΙ      ";
			}
		}
	}

	public String[][] getTable() {
		return table;
	}

	public void setTable(String[][] table) {
		this.table = table;
	}

	
	public int checkingFreehours(String[][] table, String eidikotita, double duration) {// βάση ημερομηνίας

		int exists = 0;

		for (int i = 1; i <= 16; i++) {
			for (int j = 1; j <= Employees.employees.size(); j++) {
				if (eidikotita.contains(Employees.employees.get(j - 1).getSpecialty())) {

					if (duration <= 30) {
						if (table[i][j].contains("ΟΧΙ")) {
							System.out.println(table[i][0]);
							exists = j;
							break; // για να έφτασε εδώ σημαίνει ότι έχει βρει εναν γιατρο με κενό την ώρα
									// table[i][0]
									// άρα βγαίνω τώρα απο αυτην την ζώνη ώρας, θέλω να αλλάξει τώρα το i για να
									// εκτυπώσω και
									// άλλες κενές ώρες στον πελάτη , το break βγαίνει απο την for των j δλδ των
									// γιατρων
						}
					} else {
						double totalcells = (duration / 30);
						int pl = 0;
						int y = 0;
						if ((i + totalcells) <= 17) {

							if ((duration % 30) == 0) {
								for (y = 0; y < totalcells; y++) {
									
									try {
										if (table[i + y][j].contains("ΟΧΙ")) {
											pl++;
										}
									} catch (ArrayIndexOutOfBoundsException e) {
										System.out.println("error with array's bounds");
									}
									
								}
							} else {
								totalcells = totalcells + 1;
								if ((i + totalcells) <= 17) {
									for (y = 0; y < totalcells; y++) {
										
										try {
											if (table[i + y][j].contains("ΟΧΙ")) {
												pl++;
											}
										}catch (ArrayIndexOutOfBoundsException e) {
											System.out.println("error with array's bounds.");
										}
										
									}
								}
							}
							if (pl == totalcells) {

								String temp = null;
								
								try {
									if ((i != 1) && (i != 2)) {
										temp = table[i][0].substring(0, 2);
									} else {
										temp = table[i][0].substring(0, 1);
									}
								}catch (ArrayIndexOutOfBoundsException e) {
									System.out.println("error with array's bounds.");
								}
								

								if (pl % 2 == 0) {
									double tempint = Double.parseDouble(temp);
									tempint = tempint + pl / 2;
									
									try {
										if (tempint == 17) {
											System.out.println(table[i][0] + " - 17:00 ");
											exists = j;
											break;
										} else {
	
											System.out.println(table[i][0] + " - " + table[(int) (i + totalcells)][0]);
											exists = j;
											break;
										}
									}catch (ArrayIndexOutOfBoundsException e) {
										System.out.println("error with array's bounds.");
									}
									
								} else {
									double tempint1 = Double.parseDouble(temp);

									if (i % 2 != 0) {
										tempint1 = tempint1 + (pl + 1) / 2 - 0.5;
										String h = String.valueOf(tempint1);
										h = h.substring(0, 2);
										h = h + ":30";
										
										try {
											if (tempint1 == 17) {
												System.out.println(table[i][0] + " - 17:00 ");
												exists = j;
												break;
											} else {
												System.out.println(table[i][0] + " - " + h);
												exists = j;
												break;
											}
										}catch (ArrayIndexOutOfBoundsException e) {
											System.out.println("error in array's bounds.");
										}
										
									} else {
										tempint1 = tempint1 + (pl + 1) / 2;
										String h = String.valueOf(tempint1);
										h = h.substring(0, 2);
										
										try {
											if (tempint1 == 17) {
												System.out.println(table[i][0] + " - 17:00 ");
												exists = j;
												break;
											} else {
												System.out.println(table[i][0] + " - " + h + ":00");
												exists = j;
												break;
											}
										}catch (ArrayIndexOutOfBoundsException e) {
											System.out.println("error in array's bounds.");
										}

									}
								}

							}

						}
					}
				}
			}
		}
		// με την εκτέλεση αυτής της μεθόδου, στον πελάτη θα έχουν εκτυπωθεί όλες οι
		// διαθέσιμες ώρες της μέρας που
		// επέλεξε. ο πελάτης μετά θα εισάγει την ώρα (απο αυτές) που επιθυμεί και εμείς
		// θα το διαβάζουμε και θα
		// καταχωρούμε το ραντεβου .

		// αν exists 0 τότε θα ξανα ζητήσουμε ημερομηνία ή θα ρωτήσουμε αν θέλει να του
		// προτείνουμε
		// εμείς ώρες και μέρες για την εξέταση του

		return exists;
	}

	public int checkingFreehours(String[][] table, String eidikotita, double duration, String docname) {// βάση ΚΑΙ γιατρού

		int thesi = 0;
		int exists = 0;
		for (int j = 1; j <= Employees.employees.size(); j++) {
			System.out.println((docname.contains(table[0][j])));
			if (/*(eidikotita.contains(Employees.employees.get(j-1).getSpecialty())) && */(docname.contains(table[0][j]))) {
				thesi = j;
				System.out.println(j);
				break;
			}
		} // βρήκαμε τον γιατρό που θέλει μεταξύ των γιατρών μας, δλδ την στήλη που μας
			// ενδιαφέρει στον table

		for (int i = 1; i <= 16; i++) {

			if (duration <= 30) {
				
				try {
					if (table[i][thesi] == " OXI ") {
						System.out.println(table[i][0]);
						exists = thesi;
						// για να έφτασε εδώ σημαίνει ότι έχει βρει ΤΟΝ γιατρο με κενό την ώρα
						// table[i][0]
						// άρα βγαίνω τώρα απο αυτην την ζώνη ώρας, θέλω να αλλάξει τώρα το i για να
						// εκτυπώσω και
						// άλλες κενές ώρες στον πελάτη (συνεχίζει η φορ - όχι break)
					}
				}catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("error with array's bounds.");
				}
			} else {
				double totalcells = (duration / 30);
				int pl = 0;
				int y = 0;
				if ((i + totalcells) <= 17) {

					if ((duration % 30) == 0) {
						for (y = 0; y < totalcells; y++) {
							
							try {
								if (table[i + y][thesi].contains("ΟΧΙ")) {
									pl++;
								}
							}catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("error in array's bounds.");
							}
						}
					} else {
						totalcells = totalcells + 1;
						if ((i + totalcells) <= 17) {
							for (y = 0; y < totalcells; y++) {
								
								try {
									if (table[i + y][thesi].contains("ΟΧΙ")) {
										pl++;
									}
								} catch (ArrayIndexOutOfBoundsException e) {
									System.out.println("error with array's bounds.");
								}
							}
						}
					}
					if (pl == totalcells) {

						String temp = null;
						
						
						try {
							if ((i != 1) && (i != 2)) {
								temp = table[i][0].substring(0, 2);
							} else {
								temp = table[i][0].substring(0, 1);
							}
						}catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("error in array's bounds.");
						}
							
	
						if (pl % 2 == 0) {
								
							try {
								double tempint = Double.parseDouble(temp);
								tempint = tempint + pl / 2;
								if (tempint == 17) {
									System.out.println(table[i][0] + " - 17:00 ");
									exists = thesi;
									break;
								} else {
	
									System.out.println(table[i][0] + " - " + table[(int) (i + totalcells)][0]);
									exists = thesi;
									break;
								}
							}catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("error in array's bounds.");
							}
							
							
						} else {
							double tempint1 = Double.parseDouble(temp);

								if (i % 2 != 0) {
									tempint1 = tempint1 + (pl + 1) / 2 - 0.5;
									String h = String.valueOf(tempint1);
									h = h.substring(0, 2);
									h = h + ":30";
									
									try {
										if (tempint1 == 17) {
											System.out.println(table[i][0] + " - 17:00 ");
											exists = thesi;
											break;
										} else {
											System.out.println(table[i][0] + " - " + h);
											exists = thesi;
											break;
										}
									}catch (ArrayIndexOutOfBoundsException e) {
										System.out.println("error in array's bounds.");
									}
								} else {
									tempint1 = tempint1 + (pl + 1) / 2;
									String h = String.valueOf(tempint1);
									h = h.substring(0, 2);

									try {
										if (tempint1 == 17) {
											System.out.println(table[i][0] + " - 17:00 ");
											exists = thesi;
											break;
										} else {
											System.out.println(table[i][0] + " - " + h + ":00");
											exists = thesi;
											break;
										}
									}catch (ArrayIndexOutOfBoundsException e) {
										System.out.println("error in array's bounds.");
									}

								}
							}

						}

				}
			}
			// η for θα συνεχίσει μέχρι να βρει κενή ώρα στον πελάτη μας για τον
			// συγκεκριμένο γιατρο την
			// συγκεκριμένη μέρα και όταν βρει θα συνεχίζει να ψάχνει για να έχει επιλογές ο
			// πελάτης
		}
		if (exists == 0) {
			System.out.println("Δεν καταφέραμε να βρούμε ελεύθερη ώρα για το ραντεβού σας την ημέρα που ζητήσατε"
					+ "και με τον γιατρό που επιθυμείτε .");
		}
		// αν exists 0 τότε θα ξανα ζητήσουμε ημερομηνία και γιατρό ή θα ρωτήσουμε αν
		// θέλει να του προτείνουμε
		// εμείς ώρες και μέρες που να πληρούν τις προδιαγραφές του ραντεβού του
		return exists; // η θέση του γατρού
	}
}
		