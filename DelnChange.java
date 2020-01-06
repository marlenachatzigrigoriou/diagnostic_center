package polyiatrio;

import java.util.Scanner;

public class DelnChange {

static Scanner sc = new Scanner(System.in);

static int [] del = new int[3]; //τον χρειαζομαι σε δυο μεθοδους
	
	public static int [] delQuestions() {  // ΕΙΣΑΓΩΓΗ ΚΩΔ ΕΠΙΒΕΒ. ΚΑΙ ΗΜΕΡΟΜΗΝΙΑ
		
		System.out.println("Επιλέξατε να διαγράψετε κάποιο ήδη καταχωρημένο ραντεβού σας!");
		System.out.println("Παρακαλώ εισάγετε τον κωδικο επιβεβαιωσης και την ημερομηνία του ραντεβού σας!");
		
		System.out.println("Μήνας:");
		int month = sc.nextInt();
		del[0] = month;
		System.out.println("Ημέρα:");
		int day = sc.nextInt();
		del[1] = day;
		System.out.println("Κωδικος:");
		int validcode = sc.nextInt();
		del[2]= validcode;
		return del;
	}
	
	
	public static void cancelTable(int month,int day,int j, int cell,int k_value) { //ΨΑΧΝΕΙ ΣΤΟΝ ΥΠΟΛΟΙΠΟ ΤΕΙΜΠΛ ΚΑΙ ΒΑΖΕΙ ΟΧΙ ΣΤΑ ΚΕΛΙΑ ΠΟΥ ΕΧΟΥΝ
																					//ΜΕΣΑ ΤΟ VALIDCODE
		
		
		boolean exists = true;
		int k=k_value;
	
		do { //ΤΟ WHILE ΒΑΖΕΙ ΟΧΙ ΣΤΗ ΘΕΣΗ ΟΣΩΝ ΚΕΛΙΩΝ ΕΧΟΥΝ ΜΕΣΑ ΤΟΥΣ ΤΟΝ ΚΩΔΙΚΟ ΤΟΥ ΠΕΛΑΤΗ
		
			if (Calendar.getDay(month, day).getTable()[k][j].toLowerCase().contains(String.valueOf(cell))){ 
				
		
				Calendar.getDay(month, day).getTable()[k][j] = "ΟΧΙ";
				k++;
		
			} else {
			
				exists = false;
			}
		
		}while(exists == true);
	
		
	}
	
public static String [] customer_info(String stringcode, int [] del2) {
		
		boolean flag = false; 
		String [] info2 = new String[5];
		
		String stringid = null;
		int intid = 0;
		for (int i = 1; i <= 16; i++) {
			for (int y = 1; y <= Employees.employees.size(); y++) {
				if (Calendar.getDay(del2[0], del2[1]).getTable()[i][y].toLowerCase().contains(stringcode)) {
					stringid = Calendar.getDay(del2[0], del2[1]).getTable()[i][y].substring(Calendar.getDay(del2[0], del2[1]).getTable()[i][y].length()-3);
					//Η ΠΑΝΩ ΓΡΑΜΜΗ ΞΕΧΩΡΙΖΕΙ ΤΟ ID ΑΠΟ ΤΟ ΚΕΛΙ ΤΟΥ ΤΕΙΜΠΛ
					
					intid = Integer.parseInt(stringid);
					flag = true; //ΓΙΝΕΤΑΙ ΤΡΟΥ ΕΦΟΣΟΝ ΒΡΕΘΕΙ Ο ΠΕΛΑΤΗΣ
					break;
				}
			}
			if (flag == true) {
				break;
			}
		}
		for (int i = 0; i <= Clients.clients.size(); i++) {
			if (Clients.clients.get(i).getId() == intid) {
				info2[0] = Clients.clients.get(i).getName();
				info2[1] = Clients.clients.get(i).getSurname();
				String stringphone = String.valueOf(Clients.clients.get(i).getPhoneNumber());
				info2[2] = stringphone;
				
				
			}
		}
		
		
		return info2;
	}
	
	public static void deleteApp(int []del) {
		
		
		
		String answer = "OXI";
		
		do {
			
			boolean found= false;
			for (int i=1;i<=16;i++) {
			
				for (int j=0;j<= Employees.employees.size();j++) {
		
					if (Calendar.getDay(del[0], del[1]).getTable()[i][j].toLowerCase().contains(String.valueOf(del[2]))) { //ΑΝ Ο ΚΩΔΙΚΟΣ ΣΤΟΝ ΠΙΝΑΚΑ ΤΕΙΜΠΛ ΕΙΝΑΙ 
																										//ΙΔΙΟΣ ΜΕ ΤΟΝ ΚΩΔΙΚΟ ΠΟΥ ΔΙΝΕΙ Ο ΠΕΛΑΤΗΣ		
						found = true;
						//ΠΡΕΠΕΙ ΝΑ ΒΡΩ ΠΟΣΑ ΚΕΛΙΑ ΠΙΑΝΕΙ ΤΟ ΡΑΝΤΕΒΟΥ ΑΥΤΟ ΣΤΟΝ ΠΙΝΑΚΑ
						
						DelnChange.cancelTable(del[0],del[1],j,del[2],i);
					
						
					}
				
				} //ΤΕΛΟΣ ΕΣΩΤ ΦΟΡ
					
			} //ΤΕΛΟΣ ΕΞΩΤ ΦΟΡ
		
			if (found == false ) {
			
				System.out.println("Δυστυχως δεν βρηκαμε καποιο καταχωρημένο ραντεβού με τον κωδικό που εισάγατε. Θελετε να προσπαθήσετε ξανα;");
				answer = sc.nextLine();
			
			
			} else {
			
				System.out.println("Το ραντεβού σας διεγράφη.");
				answer = "OXI";
				
			}
		
		}while (answer == "NAI");
		
		
		
	} //ΤΕΛΟΣ ΜΕΘΟΔΟΥ
	
	
	
	
	public static int [] changeQuestions() {  // ΕΙΣΑΓΩΓΗ ΚΩΔ ΕΠΙΒΕΒ. ΚΑΙ ΗΜΕΡΟΜΗΝΙΑ
		int [] del2 = new int[3];
		System.out.println("Επιλέξατε να αλλαξετε κάποιο ήδη καταχωρημένο ραντεβού σας!");
		System.out.println("Παρακαλώ εισάγετε τον κωδικο επιβεβαιωσης και την ημερομηνία του παλαιου ραντεβού!");
		
		System.out.println("Μήνας:");
		int month = sc.nextInt();
		del2[0] = month;
		System.out.println("Ημέρα:");
		int day = sc.nextInt();
		del2[1] = day;
		System.out.println("Κωδικος:");
		int validcode = sc.nextInt();
		del2[2]= validcode;
		return del2;
	}
	
	
	public static void changeApp(int del2[]) {
		
		
		
		
		System.out.println("Για την μεταφορά του ραντεβού σας επιθυμείτε να διατηρήσουμε τα ήδη υπάρχοντα στοιχεία του ραντεβού;  \\nΝΑΙ / ΟΧΙ"); 
		String ans =sc.nextLine();
		
		if (ans.equals("NAI")) {
			
			String []info= new String[5]; 
			String []info2 = new String[5];
			info=ans1(del2);
			int exetasi_duration=ans1duration(info[2],info[0]);
			
			info2=DelnChange.customer_info(String.valueOf(del[2]),del2); //ΓΕΜΙΖΩ ΤΙΣ 3 ΠΡΩΤΕΣ ΘΕΣΕΙΣ ΤΟΥ 
							//ΠΙΝΑΚΑ ΜΕ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΠΕΛΑΤΗ
			
			info2[3]=info[0];
			info2[4]=String.valueOf(exetasi_duration);
			
			
			deleteApp(del2); //ΔΙΑΓΡΑΦΩ ΤΟ ΠΑΛΙΟ ΡΑΝΤΕΒΟΥ ΧΡΗΣΙΜΟΠΟΙΩΝΤΑΣ ΤΗΝ ΜΕΘΟΔΟ ΔΙΑΓΡΑΦΗΣ
			
			
			String t1[] = new String[3];
			t1[1]=info[2];
			t1[2]=info[0];
			t1[0]="γιατρού";
			
		
				EnterAppointments.katachorisiRantevou2(t1,exetasi_duration,null,t1[0]);
				
				
			
	} else { //ΕΚ ΝΕΟΥ ΡΑΝΤΕΒΟΥ
		
			deleteApp(del2); //ΠΡΩΤΑ ΔΙΑΓΡΑΦΩ ΤΟ ΡΑΝΤΕΒΟΥ ΧΡΗΣΙΜΟΠΟΙΩΝΤΑΣ ΤΗΝ ΜΕΘΟΔΟ ΔΙΑΓΡΑΦΗΣ
			String []t = EnterAppointments.questionsToBegin();
		
			int duration =EnterAppointments.choiceDuration(t);
		
			if (t[0].contains("ημερομηνίας")) { //ΑΝ ΕΠΙΛΕΞΕΙ ΒΑΣΗ ΗΜΕΡΟΜΗΝΙΑΣ
								EnterAppointments.katachorisiRantevou1(t, duration);
			
			} else { //ΒΑΣΗ ΓΙΑΤΡΟΥ
			
				EnterAppointments.katachorisiRantevou2(t, duration, "katachorisi", null);
			}
		
	} //ΤΕΛΟΣ ΙΦ
		
		
		
	
	}//ΤΕΛΟΣ ΜΕΘΟΔΟΥ
	
	
	public static String[] ans1(int []del2) {
		
		
		String exetasi=null;
		String doctor=null;
		String eidikotita = null;
		String [] info = new String[3];
		
		
		for (int i=1;i<=16;i++) {
			
			for (int j=0;j<= Employees.employees.size();j++) {
	
				if (Calendar.getDay(del2[0], del2[1]).getTable()[i][j].toLowerCase().contains(String.valueOf(del2[2]))) {//ΕΝΤΟΠΙΖΩ ΤΟ ΡΑΝΤΕΒΟΥ ΣΤΟΝ ΤΕΙΜΠΛ
				
					
					exetasi= Calendar.getDay(del2[0], del2[1]).getTable()[i][j].substring(8); //ΟΝΟΜΑ ΕΞΕΤΑΣΗΣ ΤΟΥ ΠΑΛΙΟΥ ΡΑΝΤΕΒΟΥ
					doctor = Calendar.getDay(del2[0], del2[1]).getTable()[0][j]; //ΟΝΟΜΑ ΓΙΑΤΡΟΥ ΤΟΥ ΠΑΛΙΟΥ ΡΑΝΤΕΒΟΥ
					eidikotita = Employees.employees.get(j).getSpecialty(); //ΕΙΔΙΚΟΤΗΤΑ ΕΞΕΤΑΣΗΣ ΠΑΛΙΟΥ ΡΑΝΤΕΒΟΥ
					
					info[0]=exetasi;
					info[1]=doctor;
					info[2]=eidikotita;
				} //ΤΕΛΟΣ ΕΣΩΤ ΙΦ
				
			}//ΤΕΛΟΣ ΕΣΩΤ ΦΟΡ
			
		}//ΤΕΛΟΣ ΕΞΩΤ ΦΟΡ
		
		return info;	
		
	}//end of method ans1
	
	
	public static int ans1duration(String a,String b) {
		
		int exetasi_duration =0;
		
		for (int i=0;i<Services.eidikotitesoles.size();i++) {
			if (Services.eidikotitesoles.get(i).equals(a)) { //Η ΕΞΕΤΑΣΗ ΑΝΗΚΕΙ ΣΤΗ ΣΥΓΚΕΚΡΙΜΕΝΗ ΥΠΟΛΙΣΤΑ ΠΧ ΑΙΜΑΤΟΛΟΓΙΚΕΣ
				
				for (int j=0;j<Services.eidikotitesoles.get(i).size();j++) {
					
					if (b.equals(Services.eidikotitesoles.get(i).get(j).getName())) { //ΕΝΤΟΠΙΖΩ ΤΗΝ ΕΞΕΤΑΣΗ ΣΤΗΝ ΑΝΤΙΣΤΟΙΧΗ ΛΙΣΤΑ 
						
						exetasi_duration =Services.eidikotitesoles.get(i).get(j).getDuration();
						
					}
				}//ΤΕΛΟΣ ΕΣΩΤ ΦΟΡ
			
			
			}
			
		}//ΤΕΛΟΣ ΕΞΩΤ ΦΟΡ
		
		return exetasi_duration;
		
		
	}//end of method ans1duration
	
	
	
	
	
	
	
	
	
	
	
}//ΤΕΛΟΣ ΚΛΑΣΗΣ
		
	

