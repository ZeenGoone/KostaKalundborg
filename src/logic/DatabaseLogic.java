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
import entity.tenancy.Caravan;
import entity.tenancy.Hut;
import entity.tenancy.LuxuryHut;
import entity.tenancy.Tent;

public class DatabaseLogic {
	static ArrayList<Customer> customerBase;
	static ArrayList<CampChief> campchiefBase;
	static ArrayList<Receptionist> receptionistBase;
	
	public DatabaseLogic(){
		
	}

	public static void saveCustomer(Customer customer){
		// Get current Customer database from file
		customerBase = getCustomers();
		// Initialise testing variable
		boolean testCustomer = false;
		// Test if customer exists in database
		for(Customer c:customerBase){
			if(c.getPhonenumber().equals(customer.getPhonenumber())){
				testCustomer = true;
			}
		}
		// If Customer doesn't exist add to database and write updated database to file
		if(!testCustomer){
			customerBase.add(customer);
			writeFile("customer");
		}
	}
	public static void saveCampChief(CampChief campchief){
		// Get current CampChief database
		campchiefBase = getCampChief();
		// Set up boolean test variable
		boolean testCampChief = false;
		for(CampChief c:campchiefBase){
			// Check if campchief exists in database allready
			if(c.getPhonenumber().equals(campchief.getPhonenumber())){
				testCampChief = true;
			}
		}
		// If campchief doesn't exist add to database and write updated database to file
		if(!testCampChief){
			campchiefBase.add(campchief);
			writeFile("campchief");
		}
	}
	public static void saveReceptionist(Receptionist receptionist){
		// Get current receptionist database
		receptionistBase = getReceptionist();
		// Boolean variable for checking allready existing
		boolean testReceptionist = false;
		// Go through database
		for(Receptionist r:receptionistBase){
			// If receptionist exists set test true
			if(r.getPhonenumber().equals(receptionist.getPhonenumber())){
				testReceptionist = true;
			}
		}
		if(!testReceptionist){
			// If receptionist wasn't in database allready add it and write updated database to file
			receptionistBase.add(receptionist);
			writeFile("receptionist");
		}
	}
	
	public static ArrayList<Customer> getCustomers(){
		// Read customerdatabase from file and return it
		customerBase = readFile("customer");
		return customerBase;
	}
	public static ArrayList<Receptionist> getReceptionist(){
		// Sort receptionists from employee database and return database
		receptionistBase = readFile("receptionist");
		ArrayList<Receptionist> tempDB = receptionistBase;
		for(Receptionist r:tempDB){
			if(r.getAdministrator()){
				tempDB.remove(r);
			}
		}
		receptionistBase = tempDB;
		return receptionistBase;
	}
	public static ArrayList<CampChief> getCampChief(){
		// Sort receptionist from Employee database and return campchiefs
		campchiefBase = readFile("campchief");
		ArrayList<CampChief> tempDB = campchiefBase;
		for(CampChief c:tempDB){
			if(!c.getAdministrator()){
				tempDB.remove(c);
			}
		}
		campchiefBase = tempDB;
		return campchiefBase;
	}
	private static ArrayList readFile(String type){
		// Declare local variables
		ArrayList tempDB = databaseType(type);
		String dbFile = fileType(type);
		BufferedReader br = null;
		String input = "";
		String csvType = ";";

		// Open file for reading into a buffer
		try {
			br = new BufferedReader(new FileReader(dbFile));
			while ((input = br.readLine()) != null) {
				// Adds to database depending on type
				readMethod(type, tempDB, input, csvType);
			}
		// Catch statements for exceptions
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
		// Return the selected Database
		return tempDB;
	}

	private static void readMethod(String type, ArrayList tempDB, String input, String csvType) {
		// Split csv elements into String array
		String[] tempDBspot = input.split(csvType);
		// Depending on type add to corresponding Database
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
	private static Customer addCustomer(String[] s){
		// Split the stringarray into correct format for the Customer class
		return new Customer(s[1], s[0]);
	}
	private static Receptionist addReceptionist(String[] s){
		// Split the stringarray into correct format for the Receptionist class
		return new Receptionist(s[1], s[0], s[2]);
	}
	private static CampChief addCampChief(String[] s){
		// Split the stringarray into correct format for the CampChief class
		return new CampChief(s[1], s[0], s[2], Boolean.getBoolean(s[3]));
	}
	
	private static void writeFile(String type){
		// Declare local variables
		String dbFile = fileType(type);
		BufferedWriter bw = null;
		String csvType = ";";
		// Open file for writing
		try {
			bw = new BufferedWriter(new FileWriter(dbFile));
			// Call filingMethod for writing correct format depending on type
			filingMethod(type, bw, csvType);
		// Exception handling
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

	private static void filingMethod(String type, BufferedWriter bw, String csvType) throws IOException {
		// Writes to file corresponding to correct Class
		switch(type){
		case "customer":
			for(Customer c:customerBase){
				bw.write(c.getPhonenumber() + csvType);
				bw.write(c.getName() + "\n");
			}
			break;
		case "receptionist":
			fileEmployees(bw, csvType);
			break;
		case "campchief":
			fileEmployees(bw, csvType);
			break;
		}
	}

	private static void fileEmployees(BufferedWriter bw, String csvType) throws IOException {
		// Update employee database
		for(CampChief c:campchiefBase){
			bw.write(c.getPhonenumber() + csvType);
			bw.write(c.getName() + csvType);
			bw.write(c.getPassword() + csvType);
			bw.write(c.getAdministrator() + "\n");
		}
		for(Receptionist r:receptionistBase){
			bw.write(r.getPhonenumber() + csvType);
			bw.write(r.getName() + csvType);
			bw.write(r.getPassword() + "\n");
		}
	}
	
	private static ArrayList<?> databaseType(String type){
		// Determine type for arraylist depending on parameter type
		switch(type){
		case "customer":
			return new ArrayList<Customer>();
		case "campchief":
			return new ArrayList<CampChief>();
		case "receptionist":
			return new ArrayList<Receptionist>();
		case "hut":
			return new ArrayList<Hut>();
		case "luxuryhut":
			return new ArrayList<LuxuryHut>();
		case "tent":
			return new ArrayList<Tent>();
		case "caravan":
			return new ArrayList<Caravan>();
		}
		return null;
	}
	
	private static String fileType(String type){
		// Return database path depending on parameter type
		switch(type){
		case "customer":
			return "Database/customerBase.db";
		case "campchief":
			return "Database/employeeBase.db";
		case "receptionist":
			return "Database/employeeBase.db";
		case "hut":
		case "luxuryhut":
		case "tent":
		case "caravan":
			return "Database/tenancyBase.db";
		}
		return null;
	}
}
