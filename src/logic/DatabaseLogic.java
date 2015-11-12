package logic;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import entity.persons.CampChief;
import entity.persons.Customer;
import entity.persons.Receptionist;

public class DatabaseLogic {
	static ArrayList<Customer> customerBase;
	static ArrayList<CampChief> campchiefBase;
	static ArrayList<Receptionist> receptionistBase;
	
	DatabaseLogic(){
		
	}

	public static void saveCustomer(Customer customer){
		customerBase = getCustomers();
		boolean testCustomer = false;
		for(Customer c:customerBase){
			if(c.getPhonenumber().equals(customer.getPhonenumber())){
				testCustomer = true;
			}
		}
		if(!testCustomer){
			customerBase.add(customer);
			writeFile("customer");
		}
	}
	public static void saveCampChief(CampChief campchief){
		campchiefBase = getCampChief();
		boolean testCampChief = false;
		for(CampChief c:campchiefBase){
			if(c.getPhonenumber().equals(campchief.getPhonenumber())){
				testCampChief = true;
			}
		}
		if(!testCampChief){
			campchiefBase.add(campchief);
			writeFile("campchief");
		}
	}
	public static void saveReceptionist(Receptionist receptionist){
		receptionistBase = getReceptionist();
		boolean testReceptionist = false;
		for(Receptionist r:receptionistBase){
			if(r.getPhonenumber().equals(receptionist.getPhonenumber())){
				testReceptionist = true;
			}
		}
		if(!testReceptionist){
			receptionistBase.add(receptionist);
			writeFile("receptionist");
		}
	}
	
	public static ArrayList<Customer> getCustomers(){
		customerBase = readFile("customer");
		return customerBase;
	}
	public static ArrayList<Receptionist> getReceptionist(){
		receptionistBase = readFile("receptionist");
		return receptionistBase;
	}
	public static ArrayList<CampChief> getCampChief(){
		campchiefBase = readFile("campchief");
		ArrayList<CampChief> tempDB = campchiefBase;
		for(CampChief c:tempDB){
			if(!c.getAdministrator()){
				
			}
		}
		return campchiefBase;
	}
	private static ArrayList readFile(String type){
		ArrayList tempDB = databaseType(type);
		String dbFile = fileType(type);
		BufferedReader br = null;
		String input = "";
		String csvType = ";";

		try {
			br = new BufferedReader(new FileReader(dbFile));
			while ((input = br.readLine()) != null) {
				String[] tempDBspot = input.split(csvType);
				switch(type){
				case "customer":
					tempDB.add(addCustomer(tempDBspot));
					break;
				case "receptionist":
					tempDB.add(addReceptionist(tempDBspot));
					break;
				case "campchief":
					tempDB.add(addCampChief(tempDBspot));
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return tempDB;
	}
	private static Customer addCustomer(String[] s){
		return new Customer(s[1], s[0]);
		
	}
	private static Receptionist addReceptionist(String[] s){
		return new Receptionist(s[1], s[0], s[2]);
	}
	private static CampChief addCampChief(String[] s){
		return new CampChief(s[1], s[0], s[2], Boolean.getBoolean(s[3]));
	}
	private static void writeFile(String type){
		
		String dbFile = fileType(type);
		BufferedWriter bw = null;
		String csvType = ";";

		try {
			bw = new BufferedWriter(new FileWriter(dbFile));
			for(Customer c:customerBase){
				bw.write(c.getPhonenumber() + csvType);
				bw.write(c.getName() + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static ArrayList<?> databaseType(String type){
		switch(type){
		case "customer":
			return new ArrayList<Customer>();
		case "campchief":
			return new ArrayList<CampChief>();
		case "receptionist":
			return new ArrayList<Receptionist>();
		}
		return null;
	}
	
	private static String fileType(String type){
		switch(type){
		case "customer":
			return "Database/customerBase.db";
		case "campchief":
			return "Database/employeeBase.db";
		case "receptionist":
			return "Database/employeeBase.db";
		}
		return null;
	}
}
