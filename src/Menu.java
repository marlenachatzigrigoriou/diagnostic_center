import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This class contains some methods who help the client to book an
 *         appointment easier and faster. They allow him to choose based on what
 *         he wants to book the appointment (date or doctor) and he can also
 *         find the examination he is looking for without knowing the exact name
 *         of it, he can simply search it by writing a few letters it might
 *         contain. Also, the class contains two methods that are useful for
 *         statistical reasons.
 * 
 */
public class Menu extends Application {

	static Scanner v = new Scanner(System.in);
	static JFrame fr;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane root = new FlowPane();
		for (int i = 0; i < 22; i++) {
			root.getChildren().add(new Button(Services.eidikotites.get(i)));
		}
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setTitle("Please choose a service");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	/**
	 * This method prints all the categories of examinations that the center
	 * provides and waits for the client to insert the one he wants.
	 * 
	 * @return = returns a string variable which is the final choice of category of
	 *         the client
	 */
	public static String chooseService() {
		String eidikotita;
		StringBuilder text = new StringBuilder();
		text.append("Please choose a service:" + "\r\n");
		for (int i = 0; i < 22; i++) {
			text.append(Services.eidikotites.get(i) + "\r\n");
		}

		if (Client.numOfClients == 1) {
			eidikotita = JOptionPane.showInputDialog(fr, text.toString());
		} else {
			eidikotita = JOptionPane.showInputDialog(fr, text.toString());
		}
		return eidikotita;
	}

	/**
	 * This method allows the client to choose based on what he wants to book the
	 * appointment (date or doctor). The method returns his final choice.
	 * 
	 * @return = returns an integer variable which represents the final choice of
	 *         criterion the client made
	 */
	public static String chooseCriterion() {

		boolean flag = true;
		String ans = null;
		while (flag) {
			ans = JOptionPane.showInputDialog(fr, "Please choose based on what you want to book your appointment."
					+ "\r\n 1.Based on date" + "\r\n 2.Based on doctor and date");
			if (!(ans.contains("1") || ans.contains("2"))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return ans;
	}

	/**
	 * This method searches amongst all the examinations of a certain category for
	 * the ones/one that contain the letter or the combination of letters that the
	 * client inserted and prints the examinations which match the search.
	 * 
	 * @param search     = the search that the client made
	 * @param eidikotita = the category of examinations the client is interested in
	 * 
	 * @return = returns a boolean variable which is true when the client found the
	 *         examination he was looking for and false when he didn't.
	 */
	public static boolean filterAndPrintServices(String search, String eidikotita) {

		boolean flag = true;
		boolean exists = false;
		String exetasi_se_lista; // the name of the examination read from the .txt file
		ArrayList<String> exetaseis_list = new ArrayList<String>(); // the results of client's search

		if (search.contains("ALL")) {

			for (int a = 0; a < 22; a++) {
				if (eidikotita.toLowerCase().contains(Services.eidikotites.get(a))) {
					int size = Services.eidikotitesoles.get(a).size();
					StringBuilder text = new StringBuilder();
					text.append("Choose the examination you wish for! \n(insert it at the next window) \n\r\n");
					for (int r = 0; r < size; r++) {
						text.append("-" + Services.eidikotitesoles.get(a).get(r).getName() + "\r\n");
						exists = true;
					}
					JOptionPane.showMessageDialog(fr, text.toString());
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
						JOptionPane.showMessageDialog(fr, "This examination doesn't exist");
						flag = false;
					} else {
						StringBuilder text = new StringBuilder();
						text.append("Choose the examination you wish for! \n(insert it at the next window) \n\r\n");
						for (int k = 0; k < exetaseis_list.size(); k++) {
							text.append("-" + exetaseis_list.get(k) + "\r\n");
							exists = true;
						}
						JOptionPane.showMessageDialog(fr, text.toString());
					}

					break; // found the category of examination the client wants, exit for loop

				}
			}
		}
		return flag;
	}

	// --------------------------------------------------------
	// --------------METHODS FOR SUMS(STATISTICS)--------------

	static int sum_categories[] = new int[22]; // services' names

	/**
	 * This method increases the corresponding cell of the table sum_categorires by
	 * one when a client books an appointment of a certain category.
	 * 
	 * @param category = the category the client chose
	 */
	public static void sumPlus(String category) { // WHEN ADDING

		System.out.println(Services.eidikotites.size());
		for (int i = 0; i < Services.eidikotites.size(); i++) {

			if (Services.eidikotites.get(i).equals(category)) {
				sum_categories[i]++; // sum of category
			}
		}
	}

	/**
	 * This method decreases the corresponding cell of the table sum_categorires by
	 * one when a client books an appointment of a certain category.
	 * 
	 * @param category = the category the client chose
	 * 
	 */
	public static void sumMinus(String category) {// WHEN REDUCING

		for (int i = 0; i < Services.eidikotites.size(); i++) {

			if (Services.eidikotites.get(i).equals(category)) {
				sum_categories[i]--; // sum of category
			}
		}
	}

}
