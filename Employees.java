package javaTest;

import java.util.ArrayList;
/**
 * @author HP
 *
 */

public class Employees {

	private static int doc_id = 0;
	private String doc_name;
	private String specialty;

	static ArrayList<Employees> employees = new ArrayList<Employees>();

	public Employees(String doc_name, String specialty) {
		super();
		Employees.doc_id = doc_id++;
		this.doc_name = doc_name;
		this.specialty = specialty;
	}

	public static void changeEmployees() {

		System.out.println("(1)ΠΡΟΣΘΗΚΗ ΝΕΟΥ ΥΠΑΛΛΗΛΟΥ \n\n(2)ΔΙΑΓΡΑΦΗ ΥΠΑΛΛΗΛΟΥ "
				+ "\n\n(3)ΤΡΟΠΟΠΟΙΗΣΗ ΣΤΟΙΧΕΙΩΝ ΥΠΑΛΛΗΛΟΥ \n\n(επιλέξτε 1, 2 ή 3) "
				+ "\n-------------------------------------");
		String ansemp = Main.in.next();
		
		while (ansemp.contains("1") || ansemp.contains("2") || ansemp.contains("3")) {

			if (ansemp.contains("1")) {
				
				System.out.println("Εισάγεται τα στοιχεία του νέου υπαλλήλου\n");
				System.out.println("Ονοματεπόνυμο:");
				Main.in.nextLine();
				String ename1 = Main.in.nextLine();
				
				System.out.println("Ειδικότητα:");
				String especialty1 = Main.in.nextLine();
				boolean fl = true;

				while (fl) {
					for (int u = 0; u < Services.eidikotites.size(); u++) {
						if (especialty1.equals(Services.eidikotites.get(u))) {
							fl = false;
						}
					}
					if (fl) {
						System.out.println(
								"Πρέπει η ειδικότητα του υπαλλήλου να είναι μία απο τις ήδη υπάρχουσες!! \nΔηλαδή μία απο τις:");
						for (int u = 0; u < Services.eidikotites.size(); u++) {
							System.out.println(Services.eidikotites.get(u));
						}
						especialty1 = Main.in.nextLine();
					}
				}
				
				Employees emp1 = new Employees(ename1, especialty1);
				Employees.listEmployees(emp1);
				System.out.println("Ο υπάλληλος καταχωρήθηκε!");
				break;

			} else if (ansemp.contains("3")) {

				System.out.println("Εισάγεται τα στοιχεία του υπαλλήλου που θέλετε να τροποποιήσετε\n");
				System.out.println("Ονοματεπόνυμο:");
				Main.in.nextLine();
				String ename1 = Main.in.nextLine();
				System.out.println("Ειδικότητα:");
				String especialty1 = Main.in.nextLine();
				int thesi = 0;

				for (int p = 0; p < Employees.employees.size(); p++) {

					if (Employees.employees.get(p).getEmp_name().equals(ename1)
							&& Employees.employees.get(p).getSpecialty().equals(especialty1)) {
						thesi = p;
					}
				}

				System.out.println("Εισάγεται τα καινούρια στοιχεία του υπαλλήλου\n");
				System.out.println("Ονοματεπόνυμο:");
				String enamenew = Main.in.nextLine();
				System.out.println("Ειδικότητα:");
				String especialtynew = Main.in.nextLine();
				boolean fl = true;

				while (fl) {
					for (int u = 0; u < Services.eidikotites.size(); u++) {
						if (especialtynew.equals(Services.eidikotites.get(u))) {
							fl = false;
						}
					}
					if (fl) {
						System.out.println(
								"Πρέπει η ειδικότητα του υπαλλήλου να είναι μία απο τις ήδη υπάρχουσες!! \nΔηλαδή μία απο τις:");
						for (int u = 0; u < Services.eidikotites.size(); u++) {
							System.out.println(Services.eidikotites.get(u));
						}
						especialtynew = Main.in.nextLine();
					}
				}

				Employees.employees.get(thesi).setEmp_name(enamenew);
				Employees.employees.get(thesi).setSpecialty(especialtynew);
				System.out.println("Τα στοιχεία είναι ενημερωμένα!");
				break;

			} else if (ansemp.contains("2")) {

				System.out.println("Εισάγεται τα στοιχεία του υπαλλήλου\n");
				System.out.println("Ονοματεπόνυμο:");
				Main.in.nextLine();
				String ename1 = Main.in.nextLine();

				System.out.println("Ειδικότητα:");
				String especialty1 = Main.in.nextLine();

				boolean fl = true;

				while (fl) {
					for (int u = 0; u < Services.eidikotites.size(); u++) {
						if (especialty1.equals(Services.eidikotites.get(u))) {
							fl = false;
						}
					}
					if (fl) {
						System.out.println(
								"Πρέπει η ειδικότητα του υπαλλήλου να είναι μία απο τις ήδη υπάρχουσες!! \nΔηλαδή μία απο τις:");
						for (int u = 0; u < Services.eidikotites.size(); u++) {
							System.out.println(Services.eidikotites.get(u));
						}
						especialty1 = Main.in.nextLine();
					}
				}

				int thesi1 = 0;

				for (int p = 0; p < Employees.employees.size(); p++) {

					if (Employees.employees.get(p).getEmp_name().equals(ename1)
							&& Employees.employees.get(p).getSpecialty().equals(especialty1)) {
						thesi1 = p;
					}
				}
				
				if (thesi1 == 0) {
					System.out.println("Δεν υπάρχει τέτοιος υπάλληλος! \nΕλέγξτε το ονοματεπώνυμο!");
				} else {
					System.out.println("Ο υπάλληλος θα διαγραφεί! \nΝΑΙ / ΟΧΙ");
					String eans = Main.in.next();

					if (eans.contains("ΝΑΙ")) {
						Employees.employees.get(thesi1).setEmp_name(" ");
						Employees.employees.get(thesi1).setSpecialty(" ");
					} else {
						System.out.println("Ο υπάλληλος δεν διεγράφη!");
					}
				}
				break;
				
			} else {
				
				System.out.println("!!επιλέξτε 1, 2 ή 3!!\n");
				System.out.println("(1)ΠΡΟΣΘΗΚΗ ΝΕΟΥ ΥΠΑΛΛΗΛΟΥ \n\n(2)ΔΙΑΓΡΑΦΗ ΥΠΑΛΛΗΛΟΥ "
						+ "\n\n(3)ΤΡΟΠΟΠΟΙΗΣΗ ΣΤΟΙΧΕΙΩΝ ΥΠΑΛΛΗΛΟΥ \n\n(επιλέξτε 1, 2 ή 3) "
						+ "\n-------------------------------------");
				ansemp = Main.in.next();
			}
		}
	}
	
	public static int getEmp_id() {
		return doc_id;
	}

	public static void setEmp_id(int doc_id) {
		Employees.doc_id = doc_id;
	}

	public String getEmp_name() {
		return doc_name;
	}

	public void setEmp_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public static void listEmployees(Employees e) {
		employees.add(e);
	}

	@Override
	public String toString() {
		return "Employees [doc_name=" + doc_name + ", specialty=" + specialty + "]";
	}

	public static ArrayList<String> returnDocNames(String eidikotita) {

		ArrayList<String> docnames = new ArrayList<String>();

		for (Employees e : employees) {
			if (e.specialty.contains(eidikotita)) {
				docnames.add(e.getEmp_name());
			}
		}

		return docnames;
	}

}

