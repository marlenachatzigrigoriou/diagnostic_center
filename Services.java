package javaTest;

import java.util.ArrayList;
/**
 * @author HP
 *
 */
public class Services {

	static ArrayList<Services> aimatologikes = new ArrayList<Services>();
	static ArrayList<Services> aktinografies = new ArrayList<Services>();
	static ArrayList<Services> allergiologikes = new ArrayList<Services>();
	static ArrayList<Services> anosologikes = new ArrayList<Services>();
	static ArrayList<Services> axonikestomogr = new ArrayList<Services>();
	static ArrayList<Services> biochimikes = new ArrayList<Services>();
	static ArrayList<Services> gastrenterologikes = new ArrayList<Services>();
	static ArrayList<Services> gynaikologikes = new ArrayList<Services>();
	static ArrayList<Services> ourwn = new ArrayList<Services>();
	static ArrayList<Services> kalliergeies = new ArrayList<Services>();
	static ArrayList<Services> kardiologikes = new ArrayList<Services>();
	static ArrayList<Services> magnitikestomogr = new ArrayList<Services>();
	static ArrayList<Services> mastografies = new ArrayList<Services>();
	static ArrayList<Services> mikroviologikes = new ArrayList<Services>();
	static ArrayList<Services> neurologikes = new ArrayList<Services>();
	static ArrayList<Services> ormonikes = new ArrayList<Services>();
	static ArrayList<Services> progennitikos = new ArrayList<Services>();
	static ArrayList<Services> yperichoi = new ArrayList<Services>();
	static ArrayList<Services> checkup = new ArrayList<Services>();
	static ArrayList<Services> doppler = new ArrayList<Services>();
	static ArrayList<Services> triplex = new ArrayList<Services>();
	static ArrayList<Services> paketa = new ArrayList<Services>();

	static ArrayList<ArrayList<Services>> eidikotitesoles = new ArrayList<ArrayList<Services>>();

	static ArrayList<String> eidikotites = new ArrayList<String>();

	private String name;
	private int duration;
	private String category;
	private double cost;

	public Services(String name, int duration, String category, double cost) {
		super();
		this.name = name;
		this.duration = duration;
		this.category = category;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "η εξέταση: " + name + " έχει διάρκεια " + duration + " λεπτά" + ", ανήκει στις " + category
				+ ", με κόστος " + cost + "$ \n";
	}

	public static void addAllServices() {
		eidikotitesoles.add(aimatologikes);
		eidikotitesoles.add(aktinografies);
		eidikotitesoles.add(allergiologikes);
		eidikotitesoles.add(anosologikes);
		eidikotitesoles.add(axonikestomogr);
		eidikotitesoles.add(biochimikes);
		eidikotitesoles.add(gastrenterologikes);
		eidikotitesoles.add(gynaikologikes);
		eidikotitesoles.add(ourwn);
		eidikotitesoles.add(ormonikes);
		eidikotitesoles.add(progennitikos);
		eidikotitesoles.add(yperichoi);
		eidikotitesoles.add(checkup);
		eidikotitesoles.add(doppler);
		eidikotitesoles.add(triplex);
		eidikotitesoles.add(paketa);
		eidikotitesoles.add(kalliergeies);
		eidikotitesoles.add(kardiologikes);
		eidikotitesoles.add(magnitikestomogr);
		eidikotitesoles.add(mastografies);
		eidikotitesoles.add(mikroviologikes);
		eidikotitesoles.add(neurologikes);
	}

	public static void listEidikotites() {
		eidikotites.add("αιματολογικές");
		eidikotites.add("ακτινογραφίες");
		eidikotites.add("αλλεργιολογικές");
		eidikotites.add("ανοσολογικές");
		eidikotites.add("αξονικές τομογραφίες");
		eidikotites.add("βιοχημικές");
		eidikotites.add("γαστρεντερολογικές");
		eidikotites.add("γυναικολογικές");
		eidikotites.add("ούρων");
		eidikotites.add("ορμονικές");
		eidikotites.add("προγεννητικός έλεγχος");
		eidikotites.add("υπέρηχοι");
		eidikotites.add("checkup");
		eidikotites.add("doppler");
		eidikotites.add("triplex");
		eidikotites.add("πακέτα");
		eidikotites.add("καλλιέργειες");
		eidikotites.add("καρδιολογικές");
		eidikotites.add("μαγνητικές τομογραφίες");
		eidikotites.add("μαστογραφίες");
		eidikotites.add("μικροβιολογικές");
		eidikotites.add("νευρολογικές");
	}
	
	public static void changeServcices() {

		System.out.println("(1)ΠΡΟΣΘΗΚΗ ΝΕΑΣ ΕΞΕΤΑΣΗΣ \n\n(2)ΔΙΑΓΡΑΦΗ ΕΞΕΤΑΣΗΣ "
				+ "\n\n(3)ΤΡΟΠΟΠΟΙΗΣΗ ΥΠΑΡΧΟΥΣΑΣ ΕΞΕΤΑΣΗΣ \n(επιλέξτε 1, 2 ή 3) "
				+ "\n-------------------------------------");
		String ansserv = Main.in.next();

		while (ansserv.contains("1") || ansserv.contains("2") || ansserv.contains("3")) {

			if (ansserv.contains("1")) {
				System.out.println("Επιλέξτε ποιά κατηγορία εξετάσεων θέλετε να τροποποιήσετε:\n");
				for (int y = 0; y < eidikotites.size(); y++) {
					System.out.println(eidikotites.get(y));
				}
				String anschange = Main.in.next();
				for (int y = 0; y < eidikotites.size(); y++) {
					if (anschange.contains(eidikotites.get(y))) {
						System.out.println("Τώρα εισάγεται τα χαρακτηριστικά της καινούριας εξέτασης:");
						System.out.println("Όνομα: ");
						Main.in.next();
						String name1 = Main.in.nextLine();
						System.out.println("Διάρκεια: ");
						int dur1 = Main.in.nextInt();
						String cat1 = eidikotites.get(y);
						System.out.println("Κόστος: ");
						Double cost1 = Main.in.nextDouble();
						Services s1 = new Services(name1, dur1, cat1, cost1);
						eidikotitesoles.get(y).add(s1);

					}
				}
				break;
			} else if (ansserv.contains("3")) {
				System.out.println(
						"Επιλέξτε την κατηγορία εξετάσεων όπου ανήκει η εξέταση που θέλετε να τροποποιήσετε:\n");

				for (int y = 0; y < eidikotites.size(); y++) {
					System.out.println(eidikotites.get(y));
				}

				String anschange = Main.in.next();
				for (int y = 0; y < eidikotites.size(); y++) {

					if (anschange.contains(eidikotites.get(y))) {
						System.out.println("Επιλέξτε εξέταση:\n");

						for (int k = 0; k < eidikotitesoles.get(y).size(); k++) {
							System.out.println(eidikotitesoles.get(y).get(k).getName());
						}

						int thesi = 0;
						Main.in.next();
						String ansex = Main.in.nextLine();
						for (int k = 0; k < eidikotitesoles.get(y).size(); k++) {
							if (ansex.contains(eidikotitesoles.get(y).get(k).getName())) {
								thesi = k;
							}
						}

						for (int k = 0; k < eidikotitesoles.get(y).size(); k++) {

							if (k == thesi) {
								System.out.println(
										"Τροποποίηση: \n\n(1)Ονόματος \n\n(2)Διάρκειας \n\n(3)Κόστους \n\n(επιλέξτε 1, 2 ή 3)"
										+ "\n-------------");
								int ansnum = Main.in.nextInt();

								while (ansnum == 1 || ansnum == 2 || ansnum == 3) {
									if (ansnum == 1) {
										System.out.println("Εισάγετε το όνομα");
										Main.in.next();
										String newname = Main.in.nextLine();
										eidikotitesoles.get(y).get(k).setName(newname);
										System.out.println("Η αλλαγή καταχωρήθηκαι!");
										break;
									} else if (ansnum == 2) {
										System.out.println("Εισάγετε την διάρκεια ");
										int newdur = Main.in.nextInt();
										eidikotitesoles.get(y).get(k).setDuration(newdur);
										System.out.println("Η αλλαγή καταχωρήθηκαι!");
										break;
									} else if (ansnum == 3) {
										System.out.println("Εισάγετε το κόστος");
										Double newcost = Main.in.nextDouble();
										eidikotitesoles.get(y).get(k).setCost(newcost);
										System.out.println("Η αλλαγή καταχωρήθηκαι!");
										break;
									} else {
										System.out.println("Πρέπει να εισάγεται μία από τις τρεις επιλογές!");
										System.out.println(
												"Τροποποίηση: \n\n(1)Ονόματος \n\n(2)Διάρκειας \n\n(3)Κόστους \n\n(επιλέξτε 1, 2 ή 3)"
												+ "\n--------------");
										ansnum = Main.in.nextInt();
									}
								}
							}
						}
					}
				}
				break;
			} else if (ansserv.contains("2")) {
				System.out.println("Επιλέξτε ποιά κατηγορία εξετάσεων θέλετε να τροποποιήσετε:\n");
				for (int y = 0; y < eidikotites.size(); y++) {
					System.out.println(eidikotites.get(y));
				}

				Main.in.next();
				String ansdel = Main.in.nextLine();
				int thesi = 0;

				for (int y = 0; y < eidikotites.size(); y++) {

					if (ansdel.contains(eidikotites.get(y))) {
						thesi = y;
					}
				}

				System.out.println("Επιλέξτε εξέταση:\n");
				for (int k = 0; k < eidikotitesoles.get(thesi).size(); k++) {
					System.out.println(eidikotitesoles.get(thesi).get(k).getName());
				}

				String ansex = Main.in.nextLine();
				for (int k = 0; k < eidikotitesoles.get(thesi).size(); k++) {

					if (ansex.contains(eidikotitesoles.get(thesi).get(k).getName())) {
						System.out.println("Η εξέταση θα διαγραφεί! \nΝΑΙ / ΟΧΙ ");
						String ansnai = Main.in.next();
						if (ansnai.contains("ΝΑΙ")) {
							eidikotitesoles.get(thesi).get(k).setName(" ");
							eidikotitesoles.get(thesi).get(k).setDuration(0);
							eidikotitesoles.get(thesi).get(k).setCategory(" ");
							eidikotitesoles.get(thesi).get(k).setCost(0);
						}
					}
				}
				break;
			} else {
				System.out.println("επιλέξτε 1, 2 ή 3!!");
				System.out.println("(1)ΠΡΟΣΘΗΚΗ ΝΕΑΣ ΕΞΕΤΑΣΗΣ \n\n(2)ΔΙΑΓΡΑΦΗ ΕΞΕΤΑΣΗΣ "
						+ "\n\n(3)ΤΡΟΠΟΠΟΙΗΣΗ ΥΠΑΡΧΟΥΣΑΣ ΕΞΕΤΑΣΗΣ \n\n(επιλέξτε 1, 2 ή 3)"
						+ "\n------------------------------------");
				ansserv = Main.in.next();
			}
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public static ArrayList<Services> getAimatologikes() {
		return aimatologikes;
	}

	public static void setAimatologikes(ArrayList<Services> aimatologikes) {
		Services.aimatologikes = aimatologikes;
	}

	public static ArrayList<Services> getAktinografies() {
		return aktinografies;
	}

	public static void setAktinografies(ArrayList<Services> aktinografies) {
		Services.aktinografies = aktinografies;
	}

	public static ArrayList<Services> getAllergiologikes() {
		return allergiologikes;
	}

	public static void setAllergiologikes(ArrayList<Services> allergiologikes) {
		Services.allergiologikes = allergiologikes;
	}

	public static ArrayList<Services> getAnosologikes() {
		return anosologikes;
	}

	public static void setAnosologikes(ArrayList<Services> anosologikes) {
		Services.anosologikes = anosologikes;
	}

	public static ArrayList<Services> getAxonikestomogr() {
		return axonikestomogr;
	}

	public static void setAxonikestomogr(ArrayList<Services> axonikestomogr) {
		Services.axonikestomogr = axonikestomogr;
	}

	public static ArrayList<Services> getBiochimikes() {
		return biochimikes;
	}

	public static void setBiochimikes(ArrayList<Services> biochimikes) {
		Services.biochimikes = biochimikes;
	}

	public static ArrayList<Services> getGastrenterologikes() {
		return gastrenterologikes;
	}

	public static void setGastrenterologikes(ArrayList<Services> gastrenterologikes) {
		Services.gastrenterologikes = gastrenterologikes;
	}

	public static ArrayList<Services> getGynaikologikes() {
		return gynaikologikes;
	}

	public static void setGynaikologikes(ArrayList<Services> gynaikologikes) {
		Services.gynaikologikes = gynaikologikes;
	}

	public static ArrayList<Services> getOurwn() {
		return ourwn;
	}

	public static void setOurwn(ArrayList<Services> ourwn) {
		Services.ourwn = ourwn;
	}

	public static ArrayList<Services> getKalliergeies() {
		return kalliergeies;
	}

	public static void setKalliergeies(ArrayList<Services> kalliergeies) {
		Services.kalliergeies = kalliergeies;
	}

	public static ArrayList<Services> getKardiologikes() {
		return kardiologikes;
	}

	public static void setKardiologikes(ArrayList<Services> kardiologikes) {
		Services.kardiologikes = kardiologikes;
	}

	public static ArrayList<Services> getMagnitikestomogr() {
		return magnitikestomogr;
	}

	public static void setMagnitikestomogr(ArrayList<Services> magnitikestomogr) {
		Services.magnitikestomogr = magnitikestomogr;
	}

	public static ArrayList<Services> getMastografies() {
		return mastografies;
	}

	public static void setMastografies(ArrayList<Services> mastografies) {
		Services.mastografies = mastografies;
	}

	public static ArrayList<Services> getMikroviologikes() {
		return mikroviologikes;
	}

	public static void setMikroviologikes(ArrayList<Services> mikroviologikes) {
		Services.mikroviologikes = mikroviologikes;
	}

	public static ArrayList<Services> getNeurologikes() {
		return neurologikes;
	}

	public static void setNeurologikes(ArrayList<Services> neurologikes) {
		Services.neurologikes = neurologikes;
	}

	public static ArrayList<Services> getOrmonikes() {
		return ormonikes;
	}

	public static void setOrmonikes(ArrayList<Services> ormonikes) {
		Services.ormonikes = ormonikes;
	}

	public static ArrayList<Services> getProgennitikos() {
		return progennitikos;
	}

	public static void setProgennitikos(ArrayList<Services> progennitikos) {
		Services.progennitikos = progennitikos;
	}

	public static ArrayList<Services> getYperichoi() {
		return yperichoi;
	}

	public static void setYperichoi(ArrayList<Services> yperichoi) {
		Services.yperichoi = yperichoi;
	}

	public static ArrayList<Services> getCheckup() {
		return checkup;
	}

	public static void setCheckup(ArrayList<Services> checkup) {
		Services.checkup = checkup;
	}

	public static ArrayList<Services> getDoppler() {
		return doppler;
	}

	public static void setDoppler(ArrayList<Services> doppler) {
		Services.doppler = doppler;
	}

	public static ArrayList<Services> getTriplex() {
		return triplex;
	}

	public static void setTriplex(ArrayList<Services> triplex) {
		Services.triplex = triplex;
	}

	public static ArrayList<Services> getPaketa() {
		return paketa;
	}

	public static void setPaketa(ArrayList<Services> paketa) {
		Services.paketa = paketa;
	}

}
