import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Date 15-January-2020
 * 
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 * 
 *         This class manages the appointment table of a certain date. Checks
 *         whether there is space for an appointment at a certain time and/or
 *         for a certain doctor. If the time that the client wants is
 *         available,he books the appointment.If not, the center can suggest
 *         other available hours for the client to choose.
 *
 */
public class Table {

	static JFrame fr;
	private String table[][] = new String[17][Employees.employees.size() + 2]; // every object of type table has as
																				// field
																				// a table of type Table

	/**
	 * Class Constructor
	 */
	public Table() {

		table[0][0] = null;
		for (int i = 0; i < Employees.employees.size(); i++) { // column number is the same as number of doctors
			table[0][i + 1] = Employees.employees.get(i).getEmp_name();
		}

		table[1][0] = "9:00 ";
		table[2][0] = "9:30 ";
		table[3][0] = "10:00";
		table[4][0] = "10:30";
		table[5][0] = "11:00"; // columns and lines start from index 1 not 0
								// EXAMPLE
		table[6][0] = "11:30"; // null ON1 ON2 ON3 ON4 ...
		table[7][0] = "12:00"; // 9:00 OXI OXI OXI OXI ...
		table[8][0] = "12:30"; // 9:30 OXI OXI OXI OXI ...
		table[9][0] = "13:00"; // 10:00 OXI OXI OXI OXI ...
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

	/**
	 * -------Getters and Setters--------
	 */
	public String[][] getTable() {
		return table;
	}

	public void setTable(String[][] table) {
		this.table = table;
	}

	/**
	 * This method prints all the available hours of the day that the client has
	 * chosen to book the appointment based only on date. The client chooses one of
	 * these hours and the appointment is being booked. If there are no available
	 * hours that day the client is asked either to insert a new date or whether he
	 * wants the center to suggest him available hours for another day.
	 * 
	 * 
	 * @param table      = the appointment table
	 * @param eidikotita = the category of the requested examination
	 * @param duration   = the duration of the examination
	 * 
	 * @return = returns a two-dimensional table which contains every possible hour
	 *         an appointment can be booked and for each of these hours which column
	 *         (doctor) is available at the appointment table.
	 */
	public String[][] checkingFreehours(String[][] table, String eidikotita, double duration) {// BASED ON DATE

		String[][] data = new String[16][2];
		int di = 0;
		StringBuilder text1 = new StringBuilder();

		text1.append("These are the available hours.\n(you insert the time of your choice on the next window)\n");

		for (int i = 1; i <= 16; i++) {
			for (int j = 1; j <= Employees.employees.size(); j++) {

				if (eidikotita.contains(Employees.employees.get(j - 1).getSpecialty())) {

					if (duration <= 30) {
						if (table[i][j].contains("ΟΧΙ")) {

							text1.append(table[i][0] + "\r\n");
							data[di][0] = table[i][0];
							data[di][1] = String.valueOf(j);
							di++;
							break;
							// found a doctor available on time :table[i][0]
							// exit for loop, keep searching for other available doctors
						}
					} else {

						double totald = (duration / 30);
						int totalcells = (int) totald;
						int pl = 0;
						int y = 0;

						if ((i + totalcells) <= 17) {
							if ((duration % 30) == 0) {
								for (y = 0; y < totalcells; y++) {
									if (table[i + y][j].contains("ΟΧΙ")) {
										pl++;
									}
								}
							} else {
								totalcells = totalcells + 1;
								if ((i + totalcells) <= 17) {
									for (y = 0; y < totalcells; y++) {
										if (table[i + y][j].contains("ΟΧΙ")) {
											pl++;
										}
									}
								}
							}
							if (pl == totalcells) {

								String temp = "";

								if ((i != 1) && (i != 2)) {
									temp = table[i][0].substring(0, 2);
								} else {
									temp = table[i][0].substring(0, 1);
								}

								if (pl % 2 == 0) {

									double tempint = Double.parseDouble(temp);
									tempint = tempint + pl / 2;

									if (tempint == 17) {

										/* System.out.println(table[i][0] + " - 17:00 "); */
										text1.append(table[i][0] + " - 17:00 " + "\r\n");
									} else {
										text1.append(table[i][0] + " - " + table[(int) (i + totalcells)][0]);
										/*
										 * System.out.println(table[i][0] + " - " + table[(int) (i + totalcells)][0]);
										 */
										// data[di][0] = table[i][0];
										// data[di][1] = String.valueOf(j);
										// break;
									}

								} else {
									double tempint1 = Double.parseDouble(temp);

									if ((i % 2) != 0) {

										tempint1 = tempint1 + (pl + 1) / 2 - 0.5;
										String h = String.valueOf(tempint1);
										h = h.substring(0, 2);
										h = h + ":30";

										if (tempint1 == 17) {

											/* System.out.println(table[i][0] + " - 17:00 "); */
											text1.append(table[i][0] + " - 17:00 " + "\r\n");

										} else {

											/*
											 * System.out.println( "mpika else 17"); System.out.println(table[i][0] +
											 * " - " + h);
											 */
											text1.append(table[i][0] + " - " + h + "\r\n");

										}
									} else {

										tempint1 = tempint1 + (pl + 1) / 2;
										String h = String.valueOf(tempint1);
										h = h.substring(0, 2);

										if (tempint1 == 17) {
											text1.append(table[i][0] + " - 17:00 " + "\r\n");
											/* System.out.println(table[i][0] + " - 17:00 "); */

										} else {
											text1.append(table[i][0] + " - " + h + ":00" + "\r\n");
											/* System.out.println(table[i][0] + " - " + h + ":00"); */

										}

									}
								}

							}
							data[di][0] = table[i][0];
							data[di][1] = String.valueOf(j);
							di++;
							break;
						}
					}
				}

			}
		}
		JOptionPane.showMessageDialog(fr, text1.toString());

		return data;

	}

	/**
	 * This method prints all the available hours of the day that the client has
	 * chosen to book the appointment based on date and doctor. The client chooses
	 * one of these hours and the appointment is being booked. If there are no
	 * available hours that day the client is asked either to insert a new date and
	 * doctor or whether he wants the center to suggest him available hours for
	 * another day.
	 * 
	 * @param table      = the appointment table
	 * @param eidikotita = the category of the requested examination
	 * @param duration   = the duration of the examination
	 * @param empid      = the index of the column where the requested doctor is
	 * 
	 * @return = returns an integer variable which indicates whether the client has
	 *         found a satisfying appointment or not.
	 */
	public int checkingFreehours(String[][] table, String eidikotita, double duration, int empid) {// BASED ON DATE AND
																									// EMPLOYEE

		int thesi = 0;
		int exists = 0;
		StringBuilder text1 = new StringBuilder();
		for (int j = 0; j < Employees.employees.size(); j++) {
			if (empid == j) {
				thesi = j + 1;
				break;
			}
		}

		text1.append("These are the available hours.\\n(you insert the time of your choice on the next window)\n");

		for (int i = 1; i <= 16; i++) {

			if (duration <= 30) {

				if (table[i][thesi].contains("ΟΧΙ")) {
					/* System.out.println(table[i][0]); */
					text1.append(table[i][0] + "\r\n");
					exists = thesi;

					// found the requested doctor available on time: table[i][0]
					// keep searching for other available hours of the same doctor
				}
			} else {
				double totald = (duration / 30);
				int totalcells = (int) totald;
				int pl = 0;
				int y = 0;

				if ((i + totalcells) <= 17) {

					if ((duration % 30) == 0) {
						for (y = 0; y < totalcells; y++) {
							if (table[i + y][thesi].contains("ΟΧΙ")) {
								pl++;
							}
						}
					} else {
						totalcells = totalcells + 1;
						if ((i + totalcells) <= 17) {
							for (y = 0; y < totalcells; y++) {
								if (table[i + y][thesi].contains("ΟΧΙ")) {
									pl++;
								}
							}
						}
					}
					if (pl == totalcells) {

						String temp = null;
						if ((i != 1) && (i != 2)) {
							temp = table[i][0].substring(0, 2);
						} else {
							temp = table[i][0].substring(0, 1);
						}

						if (pl % 2 == 0) {
							double tempint = Double.parseDouble(temp);
							tempint = tempint + pl / 2;
							if (tempint == 17) {
								/* System.out.println(table[i][0] + " - 17:00 "); */
								text1.append(table[i][0] + " - 17:00 " + "\r\n");
								// exists = thesi;
								// break;
							} else {

								/*
								 * System.out.println(table[i][0] + " - " + table[(int) (i + totalcells)][0]);
								 */
								text1.append(table[i][0] + " - " + table[(int) (i + totalcells)][0] + "\r\n");
								// exists = thesi;
								// break;
							}
						} else {
							double tempint1 = Double.parseDouble(temp);

							if (i % 2 != 0) {
								tempint1 = tempint1 + (pl + 1) / 2 - 0.5;
								String h = String.valueOf(tempint1);
								h = h.substring(0, 2);
								h = h + ":30";
								if (tempint1 == 17) {
									/* System.out.println(table[i][0] + " - 17:00 "); */
									text1.append(table[i][0] + " - 17:00 " + "\r\n");
									// exists = thesi;
									// break;
								} else {
									/* System.out.println(table[i][0] + " - " + h); */
									text1.append(table[i][0] + " - " + h + "\r\n");
									// exists = thesi;
									// break;
								}
							} else {
								tempint1 = tempint1 + (pl + 1) / 2;
								String h = String.valueOf(tempint1);
								h = h.substring(0, 2);

								if (tempint1 == 17) {
									/* System.out.println(table[i][0] + " - 17:00 "); */
									text1.append(table[i][0] + " - 17:00 " + "\r\n");
									// exists = thesi;
									// break;
								} else {
									/* System.out.println(table[i][0] + " - " + h + ":00"); */
									text1.append(table[i][0] + " - " + h + ":00" + "\r\n");
									// exists = thesi;
									// break;
								}

							}
						}
						exists = thesi;
					}

				}
			}

			/*
			 * for loop continues till we find an available hour for the specific doctor the
			 * specific hour. When we find that we keep on searching for more hours just so
			 * that our client can have more options to choose from.
			 */

		}

		JOptionPane.showMessageDialog(fr, text1.toString());

		/*
		 * if exists=0 then we ask for another date and doctor or ask whether the client
		 * wants us to suggest him days and hours that satisfy his initial request.
		 */

		return exists;
	}
}
