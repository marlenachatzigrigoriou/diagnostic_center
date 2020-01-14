import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This class manages the services that the medical center provides its
 *         clients.
 *
 */
public class Services {

	// Lists of examinations of every category
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

	static JFrame fr;

	static ArrayList<ArrayList<Services>> eidikotitesoles = new ArrayList<ArrayList<Services>>();

	static ArrayList<String> eidikotites = new ArrayList<String>();

	/**
	 * Name of examination
	 */
	private String name;
	/**
	 * Duration of the examination
	 */
	private int duration;
	/**
	 * Category in which the examination belongs
	 */
	private String category;
	/**
	 * The cost of the examination
	 */
	private double cost;

	/**
	 * Class Constructor
	 */
	public Services(String name, int duration, String category, double cost) {
		super();
		this.name = name;
		this.duration = duration;
		this.category = category;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "The examination: " + name + " lasts " + duration + " minutes" + ", belongs to category " + category
				+ "and costs " + cost + "$ \n";
	}

	/**
	 * This method adds in the list eidikotitesoles the list of examinations of
	 * every category. The list is type ArrayList<Services>.
	 */
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

	/**
	 * This method adds in the list eidikotites the names of every category of
	 * examinations the center provides. The list is type String.
	 */
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

	static JLabel num = new JLabel();

	/**
	 * This method allows the medical center to edit the services it provides. The
	 * center can add a new examination, delete an already existing one or modify
	 * the info of an examination.
	 */
	public static void changeServcices() {
		String ansserv = JOptionPane.showInputDialog(fr, "(1)ADD A NEW SERVICE" + "\r\n (2)DELETE A SERVICE "
				+ "\r\n  (3)MODIFY EXISTING SERVICE" + "\r\n  (choose 1, 2 or 3)");

		while (ansserv.contains("1") || ansserv.contains("2") || ansserv.contains("3")) {

			if (ansserv.contains("1")) {
				StringBuilder text = new StringBuilder();
				text.append("Choose which category of examinations you want to modify:" + "\r\n");
				for (int y = 0; y < eidikotites.size(); y++) {
					text.append(eidikotites.get(y) + "\r\n");
				}
				String anschange = JOptionPane.showInputDialog(fr, text.toString());
				for (int y = 0; y < eidikotites.size(); y++) {
					if (anschange.contains(eidikotites.get(y))) {
						JOptionPane.showMessageDialog(fr, "Now add the characteristics of the new examination:");
						String name1 = JOptionPane.showInputDialog(fr, "Name:");
						String dur;
						dur = JOptionPane.showInputDialog(fr, "Duration");
						int dur1 = Integer.parseInt(dur);
						String cat1 = eidikotites.get(y);
						String cost;
						cost = JOptionPane.showInputDialog(fr, "Price:");
						Double cost1 = Double.parseDouble(cost);
						Services s1 = new Services(name1, dur1, cat1, cost1);
						eidikotitesoles.get(y).add(s1);
						JOptionPane.showMessageDialog(fr, "Changes have been saved!");

					}
				}
				break;
			} else if (ansserv.contains("3")) {
				StringBuilder text = new StringBuilder();
				text.append("Choose the category of examinations where the examination you want to modify belongs:"
						+ "\r\n");
				for (int y = 0; y < eidikotites.size(); y++) {
					text.append(eidikotites.get(y) + "\r\n");
				}
				String anschange = JOptionPane.showInputDialog(fr, text.toString());
				for (int y = 0; y < eidikotites.size(); y++) {

					if (anschange.contains(eidikotites.get(y))) {
						StringBuilder textarea = new StringBuilder();
						textarea.append("Choose examination:" + "\r\n");
						for (int k = 0; k < eidikotitesoles.get(y).size(); k++) {
							textarea.append(eidikotitesoles.get(y).get(k).getName() + "\r\n");
						}
						String ansex = JOptionPane.showInputDialog(fr, textarea.toString());
						int thesi = 0;
						for (int k = 0; k < eidikotitesoles.get(y).size(); k++) {
							if (ansex.contains(eidikotitesoles.get(y).get(k).getName())) {
								thesi = k;
							}
						}

						for (int k = 0; k < eidikotitesoles.get(y).size(); k++) {
							if (k == thesi) {
								String an = JOptionPane.showInputDialog(fr, "Modificate:" + "\r\n (1)Name "
										+ "\r\n (2)Duration" + "\r\n (3)Price" + "\r\n (choose 1, 2 or 3)");
								int ansnum = Integer.parseInt(an);
								while (ansnum == 1 || ansnum == 2 || ansnum == 3) {
									if (ansnum == 1) {
										String newname = JOptionPane.showInputDialog(fr, "Insert name: ");
										eidikotitesoles.get(y).get(k).setName(newname);
										JOptionPane.showMessageDialog(fr, "Change has been saved!");
										break;
									} else if (ansnum == 2) {
										String newd = JOptionPane.showInputDialog(fr,
												"Insert the duration (in minutes): ");
										int newdur = Integer.parseInt(newd);
										eidikotitesoles.get(y).get(k).setDuration(newdur);
										JOptionPane.showMessageDialog(fr, "Change has been saved!");
										break;
									} else if (ansnum == 3) {
										String newc = JOptionPane.showInputDialog(fr, "Insert price: ");
										Double newcost = Double.parseDouble(newc);
										eidikotitesoles.get(y).get(k).setCost(newcost);
										JOptionPane.showMessageDialog(fr, "Change has been saved!");
										break;
									} else {
										an = JOptionPane.showInputDialog(fr,
												"You have to choose one of the three options!" + "\r\n (1)Name "
														+ "\r\n (2)Duration" + "\r\n (3)Price"
														+ "\r\n (choose 1, 2 ή 3)");
										ansnum = Integer.parseInt(an);
									}
								}
							}
						}
					}
				}
				break;

			} else if (ansserv.contains("2")) {
				StringBuilder text = new StringBuilder();
				text.append("Choose which category of examinatins you want to modify:" + "\r\n");
				for (int y = 0; y < eidikotites.size(); y++) {
					text.append(eidikotites.get(y) + "\r\n");
				}
				String ansdel = JOptionPane.showInputDialog(fr, text.toString());

				int thesi = 0;

				for (int y = 0; y < eidikotites.size(); y++) {

					if (ansdel.contains(eidikotites.get(y))) {
						thesi = y;
					}
				}

				JOptionPane.showMessageDialog(fr, "Choose examination:");
				StringBuilder text1 = new StringBuilder();
				text1.append("Choose examination:" + "\r\n");
				for (int k = 0; k < eidikotitesoles.get(thesi).size(); k++) {
					text1.append(eidikotitesoles.get(thesi).get(k).getName() + "\r\n");
				}
				String ansex = JOptionPane.showInputDialog(fr, text1.toString());
				for (int k = 0; k < eidikotitesoles.get(thesi).size(); k++) {

					if (ansex.contains(eidikotitesoles.get(thesi).get(k).getName())) {
						String ansnai = JOptionPane.showInputDialog(fr,
								"The examination will be deleted!" + "\r\n YES " + "\r\n NO ");
						if (ansnai.contains("YES")) {
							eidikotitesoles.get(thesi).get(k).setName(" ");
							eidikotitesoles.get(thesi).get(k).setDuration(0);
							eidikotitesoles.get(thesi).get(k).setCategory(" ");
							eidikotitesoles.get(thesi).get(k).setCost(0);
							JOptionPane.showMessageDialog(fr, "Examination was deleted!");
							break;
						}
					}
				}
				break;
			} else {
				ansserv = JOptionPane.showInputDialog(fr, "choose 1, 2 ή 3!!" + "\r\n (1)ADD A NEW SERVICE "
						+ "\r\n (2)DELETE A SERVICE" + "\r\n (3)MODIFY EXISTING SERVICE");
			}
		}
	}

	/**
	 * -------------Getters and Setters------------
	 */
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
