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
	public static void main(String[] args){
		for(Customer c:getCustomers()){
			System.out.print("kunde id: " + c.getPhonenumber() + " ");
			System.out.println("kunde navn: " + c.getName());
		}
		System.out.println("Tilføjer nu kunden 12121212-id og Henning Poulsen-name");
		Customer temp = new Customer("Henning Poulsen", "12121212");
		saveCustomer(temp);
		System.out.println("Nu ser vi om den er blevet tilføjet");
		for(Customer c:getCustomers()){
			System.out.print("kunde id: " + c.getPhonenumber() + " ");
			System.out.println("kunde navn: " + c.getName());
		}
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
				tempDB.add(new Customer(tempDBspot[1], tempDBspot[0]));
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
