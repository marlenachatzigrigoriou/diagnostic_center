import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This is a class for managing medical center's clients.
 *
 */
public class Client {

	/**
	 * name of the client
	 */
	private String name;
	/**
	 * surname of client
	 */
	private String surname;
	/**
	 * client's phone number
	 */
	private String phoneNumber;
	static int numOfClients = 0;
	private int id = 0;
	static JFrame fr;

	public static Scanner mm = new Scanner(System.in);

	/**
	 * the list where every object of type Client is being added when a new client
	 * is created.
	 */
	static ArrayList<Client> clients = new ArrayList<Client>();

	/**
	 * Class Constructor
	 */
	public Client(String name, String surname, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.id = id + 1;
		numOfClients++;
	}

	/**
	 * This method asks from client to insert his personal information and when this
	 * has been done the new client is being added in the client list.
	 */
	public static void questionsAboutClient() {
		int err = 0;
		while (err == 0) {
			try {
				String qClients[] = new String[3];
				/*
				 * System.out.println("Παρακαλώ εισάγετε το επώνυμό σας"); qClients[0] =
				 * mm.nextLine();
				 */
				qClients[0] = JOptionPane.showInputDialog(fr, "Please insert your surname:");
				/*
				 * System.out.println("Παρακαλώ εισάγετε το όνομά σας"); qClients[1] =
				 * mm.nextLine();
				 */
				qClients[1] = JOptionPane.showInputDialog(fr, "Please insert your name:");

				/*
				 * System.out.println("Παρακαλώ εισάγετε το τηλεφωνό σας"); qClients[2] =
				 * mm.nextLine();
				 */
				qClients[2] = JOptionPane.showInputDialog(fr, "Please insert your phone number:");
				Client c = new Client(qClients[0], qClients[1], qClients[2]);
				addClient(c);
				err++;
			} catch (InputMismatchException e) {
				/*
				 * System.out.
				 * println("Εισάγετε σωστά το ονοματεπώνυμό σας (εισάγετε ελληνικούς χαρακτηρές μόνο),\n "
				 * + "Εισάγετε σωστά το τηλέφωνο σας (μόνο αριθμητικούς χαρακτήρες).");
				 */
				JOptionPane.showMessageDialog(fr, "Insert your foull name correctly (letters only),"
						+ "\r\n Insert your phone number correctly (numbers only).");
			}
		}
	}

	/**
	 * This method adds an object of type Client in the list clients.
	 * 
	 * @param c = object of type Client
	 */
	public static void addClient(Client c) {
		clients.add(c);
	}

	/**
	 * Getters and Setters
	 */
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
		return name + " " + surname + " with phone number: " + phoneNumber;
	}

}
