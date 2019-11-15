package polyiatrio;



import java.util.ArrayList;

public class Employees {
	
	private static int doc_id = 0;
	private String doc_name;
	private String specialty;

	static ArrayList<Employees> employees = new ArrayList<Employees>();

	public Employees( String doc_name, String specialty) {
		super();
		Employees.doc_id = doc_id++;
		this.doc_name = doc_name;
		this.specialty = specialty;
	}


	public static int getDoc_id() {
		return doc_id;
	}
	public static void setDoc_id(int doc_id) {
		Employees.doc_id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	

	public void list_doctors(Employees e) {
		employees.add(e);
	}


	static ArrayList<Employees> giatroi_aimatologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_aktinografies = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_allergiologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_anosologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_axonikestomogr= new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_biochimikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_gastrenterologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_gynaikologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_ourwn = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_kalliergeies = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_kardiologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_magnitikestomogr = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_mastografies = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_mikroviologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_neurologikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_ormonikes = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_progennitikos = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_yperichoi = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_checkup = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_doppler = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_triplex = new ArrayList<Employees>();
	static ArrayList<Employees> giatroi_paketa = new ArrayList<Employees>();  /*ΚΑΤΑ ΠΟΣΟ ΜΠΟΡΟΥΜΕ ΝΑ ΕΧΟΥΜΕ ΓΙΑΤΡΟΥΣ ΣΤΑ ΠΑΚΕΤΑ;
																				ΘΑ ΕΙΝΑΙ ΙΔΙΟΙ ΜΕ ΤΟΥΣ ΑΛΛΟΥΣ ΑΦΟΥ ΤΟ ΠΑΚΕΤΟ ΕΧΕΙ 
																				ΠΟΛΛΕΣ ΥΠΗΡ. ΜΕΣΑ ΤΟΥ. ΑΛΛΑ ΠΟΙΟΥΣ;
																			*/
	
	
	
	public void listsBySpecialty() {
	
		for (int i=0;i<= employees.size()-1;i++) {
		
			if (employees.get(i).getSpecialty().equals("αιματολογικές")) {
			
				giatroi_aimatologikes.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("ακτινογραφίες")) {
				
			giatroi_aktinografies.add(employees.get(i));
			}
			
			if (employees.get(i).getSpecialty().equals("αλλεργιολογικές")) {
				
				giatroi_allergiologikes.add(employees.get(i));
			}
					
			if (employees.get(i).getSpecialty().equals("ανοσολογικές")) {
			
				giatroi_anosologikes.add(employees.get(i));
			}
					
			if (employees.get(i).getSpecialty().equals("αξονικές τομογραφίες")) {
						
				giatroi_axonikestomogr.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("βιοχημικές")) {
				
				giatroi_biochimikes.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("γαστρεντερολογικές")) {
			
				giatroi_gastrenterologikes.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("γυναικολογικές")) {
			
				giatroi_gynaikologikes.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("ούρων")) {
			
				giatroi_ourwn.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("καλλιέργειες")) {
			
				giatroi_kalliergeies.add(employees.get(i));
			}
			
			if (employees.get(i).getSpecialty().equals("καρδιολογικές")) {
			
				giatroi_kardiologikes.add(employees.get(i));
			}
			
			if (employees.get(i).getSpecialty().equals("μαγνητικές τομογραφίες")) {
				
				giatroi_magnitikestomogr.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("μαστογραφίες")) {
			
				giatroi_mastografies.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("μικροβιολογικές")) {
			
				giatroi_mikroviologikes.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("νευρολογικές")) {
			
				giatroi_neurologikes.add(employees.get(i));
			}	
				
			if (employees.get(i).getSpecialty().equals("ορμονικές")) {
			
				giatroi_ormonikes.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("προγεννητικός έλεγχος")) {
			
				giatroi_progennitikos.add(employees.get(i));
			}

			if (employees.get(i).getSpecialty().equals("υπέρηχοι")) {
						
				giatroi_yperichoi.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("checkup")) {
			
				giatroi_checkup.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("doppler")) {
			
				giatroi_doppler.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("triplex")) {
			
				giatroi_triplex.add(employees.get(i));
			}
		
			if (employees.get(i).getSpecialty().equals("πακέτα")) {
			
				giatroi_paketa.add(employees.get(i));
			}
		}
	
	}


}
