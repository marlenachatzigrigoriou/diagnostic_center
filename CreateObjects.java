import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Date 15-January-2020
 *
 * @author 8180041, 8180150, 8180111, 8180108, 8180073, 8180070, 8180074,
 *         8180152
 *
 *         This class reads the services and the employees of the medical center
 *         from .txt files and adds them in lists.
 *
 */
public class CreateObjects {

	/**
	 * This method reads a file containing the examinations of one specific category
	 * of services, creates an object of type Services and adds it in the list with
	 * all the other examinations of the same category.
	 *
	 * @param filename = is the name of the file we want to read
	 */
	public static void createServices(String filename) {

		File file = new File(filename);

		BufferedReader br = null;
		try {

			String dur, cos;
			String name1 = null;
			String category1 = null;
			int duration1 = 0;
			double cost1 = 0;
			int h = 1;
			int i = 1;
			int j = 2;
			int y = 3;
			int x = 4;

			br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {

				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				Services object;

				while (tokenizer.hasMoreTokens()) {

					if (h == i) {
						name1 = tokenizer.nextToken();
						i = i + 4;
						h++;
					} else if (h == j) {
						dur = tokenizer.nextToken();
						duration1 = Integer.parseInt(dur);
						j = j + 4;
						h++;
					} else if (h == y) {
						category1 = tokenizer.nextToken();
						y = y + 4;
						h++;
					} else if (h == x) {
						cos = tokenizer.nextToken();
						cost1 = Double.parseDouble(cos);
						h++;
					}

					if (h == (x + 1)) {
						object = new Services(name1, duration1, category1, cost1);

						for (int ex = 0; ex < 22; ex++) {
							if (category1.contains(Services.eidikotites.get(ex))) {
								Services.eidikotitesoles.get(ex).add(object);
							}
						}
						x = x + 4;
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method reads a file containing the information of the employees of the
	 * medical center, creates an object of type Employees and adds it in the list
	 * with all the other employees.
	 *
	 * @param filename = the name of the file we want to read
	 */
	public static void createEmployees(String filename) {

		File file = new File(filename);

		BufferedReader br = null;
		try {

			String name1 = null;
			String category1 = null;
			int h = 1;
			int i = 1;
			int j = 2;

			br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {

				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				Employees object;

				while (tokenizer.hasMoreTokens()) {
					if (h == i) {
						name1 = tokenizer.nextToken();
						i = i + 2;
						h++;
					} else if (h == j) {
						category1 = tokenizer.nextToken();
						h++;
					}
					if (h == (j + 1)) {
						object = new Employees(name1, category1);
						Employees.listEmployees(object);

						j = j + 2;
					}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
