import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This class manages the employees of the medical center.
 *
 */

public class Employees {

	/**
	 * Number of employees
	 */
	private static int doc_id = 0;
	/**
	 * Name of employee
	 */
	private String doc_name;
	/**
	 * The category of examinations a certain employee can undertake
	 */
	private String specialty;

	static ArrayList<Employees> employees = new ArrayList<Employees>();
	static JFrame frame;

	/**
	 * Class Constructor
	 */
	public Employees(String doc_name, String specialty) {
		super();
		Employees.doc_id = doc_id++;
		this.doc_name = doc_name;
		this.specialty = specialty;
	}

	/**
	 * This method allows the medical center to edit the information of its
	 * employees. The center can add a new employee, delete an already existing
	 * employee or modify the information of an existing employee. *
	 * 
	 */
	public static void changeEmployees() {

		/*
		 * System.out.println("(1)ΠΡΟΣΘΗΚΗ ΝΕΟΥ ΥΠΑΛΛΗΛΟΥ \n\n(2)ΔΙΑΓΡΑΦΗ ΥΠΑΛΛΗΛΟΥ " +
		 * "\n\n(3)ΤΡΟΠΟΠΟΙΗΣΗ ΣΤΟΙΧΕΙΩΝ ΥΠΑΛΛΗΛΟΥ \n\n(επιλέξτε 1, 2 ή 3) " +
		 * "\n-------------------------------------"); String ansemp = Main.in.next();
		 */
		String ansemp = JOptionPane.showInputDialog(frame, "Please choose a service:" + "\r\n (1)ADD A NEW EMPLOYEE"
				+ "\r\n (2)DELETE AN EMPLOYEE" + "\r\n (3)MODIFY INFORMATION OF EMPLOYEES" + "\r\n(choose 1, 2 or 3)");
		while (ansemp.contains("1") || ansemp.contains("2") || ansemp.contains("3")) {

			if (ansemp.contains("1")) {
				JOptionPane.showMessageDialog(frame, "Insert the information of the new employee.");
				/* System.out.println("Εισάγεται τα στοιχεία του νέου υπαλλήλου\n"); */
				String ename1 = JOptionPane.showInputDialog(frame, "Name and Surname:");
				/*
				 * System.out.println("Ονοματεπόνυμο:"); Main.in.nextLine(); String ename1 =
				 * Main.in.nextLine();
				 */

				String especialty1 = JOptionPane.showInputDialog(frame, "Specialty:");
				/*
				 * System.out.println("Ειδικότητα:"); String especialty1 = Main.in.nextLine();
				 */

				boolean fl = true;

				while (fl) {
					for (int u = 0; u < Services.eidikotites.size(); u++) {
						if (especialty1.equals(Services.eidikotites.get(u))) {
							fl = false;
						}
					}
					if (fl) {

						StringBuilder text2 = new StringBuilder();
						text2.append("Employee's specialty has to be one of the already existing ones!!"
								+ "\n Specialties are: " + "\n");

						for (int u = 0; u < Services.eidikotites.size(); u++) {
							text2.append(Services.eidikotites.get(u) + "\r\n");
						}
						/* especialty1 = Main.in.nextLine(); */
						especialty1 = JOptionPane.showInputDialog(frame, text2.toString());

					}
				}

				Employees emp1 = new Employees(ename1, especialty1);
				Employees.listEmployees(emp1);
				JOptionPane.showMessageDialog(frame, "The employee has been added!");
				break;

			} else if (ansemp.contains("3")) {

				ArrayList<String> docs1 = new ArrayList<String>();
				ArrayList<Integer> docsnum = new ArrayList<Integer>();
				StringBuilder text = new StringBuilder();
				text.append("Insert the specialty of the employee you want to modify:" + "\r\n");
				for (int t = 0; t < Services.eidikotites.size(); t++) {
					/* System.out.println(Services.eidikotites.get(t)); */
					text.append(Services.eidikotites.get(t) + "\r\n");
				}

				/*
				 * System.out.println(); Main.in.nextLine(); String especialty1 =
				 * Main.in.nextLine();
				 */
				String especialty1 = JOptionPane.showInputDialog(frame, text.toString());

				StringBuilder text1 = new StringBuilder();
				text1.append("Choose one of the employees below:" + "\r\n");
				/* System.out.println("Επιλέξτε απο τους παρακάτω υπαλλήλους:"); */

				for (int p = 0; p < Employees.employees.size(); p++) {
					if (Employees.employees.get(p).getSpecialty().equals(especialty1)) {
						text1.append(Employees.employees.get(p).getEmp_name() + "\r\n");
						/* System.out.println(Employees.employees.get(p).getEmp_name()); */
						docs1.add(Employees.employees.get(p).getEmp_name());
						docsnum.add(p);
					}
				}

				/* String ename1 = Main.in.nextLine(); */
				int thesi = 0;
				String ename1 = JOptionPane.showInputDialog(frame, text1.toString());

				for (int io = 0; io < docs1.size(); io++) {
					if (docs1.get(io).contains(ename1)) {
						thesi = docsnum.get(io);
					}
				}
				JOptionPane.showMessageDialog(frame, "Insert the employee's new information.");
				/*
				 * System.out.println("Εισάγετε τα καινούρια στοιχεία του υπαλλήλου\n");
				 * System.out.println("Ονοματεπώνυμο:"); String enamenew = Main.in.nextLine();
				 */
				String enamenew = JOptionPane.showInputDialog(frame, "Name and Surname:");
				/*
				 * System.out.println("Ειδικότητα:"); String especialtynew = Main.in.nextLine();
				 */
				String especialtynew = JOptionPane.showInputDialog(frame, "Specialty:");

				boolean fl = true;
				while (fl) {
					for (int u = 0; u < Services.eidikotites.size(); u++) {
						if (especialtynew.equals(Services.eidikotites.get(u))) {
							fl = false;
						}
					}
					if (fl) {
						StringBuilder text2 = new StringBuilder();
						text2.append(
								"Employee's specialty has to be one of the already existing ones!! Specialties are:"
										+ "\r\n");
						for (int u = 0; u < Services.eidikotites.size(); u++) {
							/* System.out.println(Services.eidikotites.get(u)); */
							text1.append(Services.eidikotites.get(u) + "\r\n");
						}
						especialtynew = JOptionPane.showInputDialog(frame, text2.toString());
					}
				}

				Employees.employees.get(thesi).setEmp_name(enamenew);
				Employees.employees.get(thesi).setSpecialty(especialtynew);
				JOptionPane.showMessageDialog(frame, "Information has been updated!");
				break;

			} else if (ansemp.contains("2")) {

				/* System.out.println("Εισάγεται τα στοιχεία του υπαλλήλου\n"); */
				JOptionPane.showMessageDialog(frame, "Insert employee's information.");
				/*
				 * System.out.println("Ονοματεπόνυμο:"); Main.in.nextLine(); String ename1 =
				 * Main.in.nextLine();
				 */
				String ename1 = JOptionPane.showInputDialog(frame, "Name and Surname:");

				/*
				 * System.out.println("Ειδικότητα:"); String especialty1 = Main.in.nextLine();
				 */
				String especialty1 = JOptionPane.showInputDialog(frame, "Specialty:");

				boolean fl = true;

				while (fl) {
					for (int u = 0; u < Services.eidikotites.size(); u++) {
						if (especialty1.equals(Services.eidikotites.get(u))) {
							fl = false;
						}
					}
					if (fl) {
						StringBuilder text1 = new StringBuilder();
						text1.append("Employee's specialty has to be one of the already existing ones!!"
								+ "\n Specialties are:" + "\n");
						/*
						 * System.out.println(
						 * "Πρέπει η ειδικότητα του υπαλλήλου να είναι μία απο τις ήδη υπάρχουσες!! \nΔηλαδή μία απο τις:"
						 * );
						 */
						for (int u = 0; u < Services.eidikotites.size(); u++) {
							text1.append(Services.eidikotites.get(u) + "\r\n");
						}
						/* especialty1 = Main.in.nextLine(); */
						especialty1 = JOptionPane.showInputDialog(frame, text1.toString());
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
					/*
					 * System.out.
					 * println("Δεν υπάρχει τέτοιος υπάλληλος! \nΕλέγξτε το ονοματεπώνυμο!");
					 */
					JOptionPane.showMessageDialog(frame,
							"Δεν υπάρχει τέτοιος υπάλληλος!" + "\r\n Check name and surname again!");
				} else {
					/*
					 * System.out.println("Ο υπάλληλος θα διαγραφεί! \nΝΑΙ / ΟΧΙ"); String eans =
					 * Main.in.next();
					 */
					String eans = JOptionPane.showInputDialog(frame,
							"This employee doesn't exist!" + "\r\n YES" + "\r\n NO");

					if (eans.contains("YES")) {
						Employees.employees.get(thesi1).setEmp_name(" ");
						Employees.employees.get(thesi1).setSpecialty(" ");
					} else {
						/* System.out.println("Ο υπάλληλος δεν διεγράφη!"); */
						JOptionPane.showMessageDialog(frame, "The employee has been deleted!");
					}
				}
				break;

			} else {

				/*
				 * System.out.println("!!επιλέξτε 1, 2 ή 3!!\n");
				 * System.out.println("(1)ΠΡΟΣΘΗΚΗ ΝΕΟΥ ΥΠΑΛΛΗΛΟΥ \n\n(2)ΔΙΑΓΡΑΦΗ ΥΠΑΛΛΗΛΟΥ " +
				 * "\n\n(3)ΤΡΟΠΟΠΟΙΗΣΗ ΣΤΟΙΧΕΙΩΝ ΥΠΑΛΛΗΛΟΥ \n\n(επιλέξτε 1, 2 ή 3) " +
				 * "\n-------------------------------------"); ansemp = Main.in.next();
				 */

				ansemp = JOptionPane.showInputDialog(frame, "choose 1, 2 or 3!!" + "\r\n (1)ADD A NEW EMPLOYEE "
						+ "\r\n (2)DELETE AN EMPLOYEE" + "\r\n (3)MODIFY INFORMATION OF EMPLOYEES");
			}
		}
	}

	/**
	 * Getters and Setters
	 */
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

	/**
	 * This method adds an object of type Employees in a list with all the other
	 * employees.
	 * 
	 * @param e = object of type Employees
	 */
	public static void listEmployees(Employees e) {
		employees.add(e);
	}

	@Override
	public String toString() {
		return "Employees [doc_name=" + doc_name + ", specialty=" + specialty + "]";
	}

	/**
	 * This method returns a list which contains the names of the employees who
	 * belong to a certain category of examinations.
	 * 
	 * @param eidikotita = the category of the examinations
	 * 
	 * @return = returns a list of type string with the names of the employees of a
	 *         certain category
	 */
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
