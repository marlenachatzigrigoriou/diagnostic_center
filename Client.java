/**
 * 
 */
package ergasia2;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * @author HP
 *
 */
public class Client {

	private String name;
	private String surname;
	private String phoneNumber;
	static int numOfClients = 0;
	private int id = 0;


	static ArrayList<Client> clients = new ArrayList<Client>();

	public Client(String name, String surname, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.id = id + 1;
		numOfClients++;
	}

	public static void questionsAboutClient() {

		boolean err = true;

		while (err) {
			try {
				String qClients[] = new String[3];
				System.out.println("Παρακαλώ εισάγετε το επώνυμό σας");
				qClients[0] = wannabeMain.in.next();
				System.out.println("Παρακαλώ εισάγετε το όνομά σας");
				qClients[1] = wannabeMain.in.next();

				System.out.println("Παρακαλώ εισάγετε το τηλεφωνό σας");
				int a = wannabeMain.in.nextInt();
				qClients[2] = String.valueOf(a);
				Client c = new Client(qClients[0], qClients[1], qClients[2]);
				addClient(c);

				err = false;
			} catch (InputMismatchException e) {
				System.err.println("Εισάγετε σωστά τα στοιχεία σας");
				System.out.println();
			}
		}
	}

	public static void addClient(Client c) {
		clients.add(c);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Ο/Η " + name + " " + surname + " με αριθμό τηλεφώνου " + phoneNumber;
	}

}
