package logic;

import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entity.persons.CampChief;
import entity.persons.Customer;
import entity.persons.Employee;
import entity.persons.Expense;
import entity.persons.Invoice;
import entity.persons.Receptionist;
import entity.tenancy.Caravan;
import entity.tenancy.Hut;
import entity.tenancy.LuxuryHut;
import entity.tenancy.Tent;

public class DatabaseLogic {
	private static ArrayList<Customer> customerBase;
	private static ArrayList<Employee> employeeBase;
	private static ArrayList<Invoice> invoiceBase;
	private static Date highseason_start = new Date(2015,6,12);
	private static Date highseason_end = new Date(2015,8,16);
	public DatabaseLogic() {

	}

	public static void saveCustomer(Customer customer) {
		// Get current Customer database from file
		customerBase = getCustomers();
		// Initialise testing variable
		boolean testCustomer = false;
		// Test if customer exists in database
		for (Customer c : customerBase) {
			if (c.getPhonenumber().equals(customer.getPhonenumber())) {
				testCustomer = true;
			}
		}
		// If Customer doesn't exist add to database and write updated database
		// to file
		if (!testCustomer) {
			customerBase.add(customer);
			writeFile("customer");
		}
	}

	public static void saveEmployee(Employee employee) {
		// Get current CampChief database
		employeeBase = getEmployee();
		// Set up boolean test variable
		boolean testEmployee = false;
		for (Employee e : employeeBase) {
			// Check if campchief exists in database allready
			if (e.getPhonenumber().equals(employee.getPhonenumber())) {
				testEmployee = true;
			}
		}
		// If campchief doesn't exist add to database and write updated database
		// to file
		if (!testEmployee) {
			employeeBase.add(employee);
			writeFile("employee");
		}
	}
	public static String getHighseasonStart() {
		return highseason_start;
	}
	public static String getHighseasonEnd() {
		return highseason_end;
	}

	public static ArrayList<Customer> getCustomers() {
		// Read customerdatabase from file and return it
		customerBase = readFile("customer");
		return customerBase;
	}

	public static ArrayList<Employee> getEmployee() {
		// Sort receptionist from Employee database and return campchiefs
		employeeBase = readFile("employeeBase");
		return employeeBase;
	}
	public static ArrayList<Invoice> getInvoiceList() {
		invoiceBase = readFile("invoice");
		return invoiceBase;
	}

	private static ArrayList readFile(String type) {
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

	private static void readMethod(String type, ArrayList tempDB, String input,
			String csvType) {
		// Split csv elements into String array
		String[] tempDBspot = input.split(csvType);
		// Depending on type add to corresponding Database
		switch (type) {
		case "customer":
			tempDB.add(addCustomer(tempDBspot));
			break;
		case "employee":
			tempDB.add(addEmployee(tempDBspot));
			break;
		case "invoice":
			tempDB.add(addInvoice(tempDBspot));
			break;
		}
	}

	private static Customer addCustomer(String[] s) {
		// Split the stringarray into correct format for the Customer class
		return new Customer(s[1], s[0]);
	}

	private static Employee addEmployee(String[] s) {
		// Split the stringarray into correct format for the Employee class
		if (Integer.getInteger(s[3]) == 1)
			return new Receptionist(s[1], s[0], s[2]);
		else if (Integer.getInteger(s[3]) == 2)
			return new CampChief(s[1], s[0], s[2]);
		else
			return null;
	}
	private static Invoice addInvoice(String[] s) {
		Invoice invoice = new Invoice(s[2], s[3]);
		int[] seasondays = getSeasondays(invoice);
		if (seasondays[0]==0) {
			
		}
		ArrayList<Expense> expenseList = readFile("expense");
		for (Expense e: expenseList) {
			invoice.registerExpense(e.getDescribtion(), e.getPrice(), e.getNumberofitems());
		}
		return invoice;
	}
	private static int[] getSeasondays(Invoice invoice) {
		Date startdate = invoice.getStartdate();
		Date enddate = invoice.getEnddate();
		int offseasondays = 0;
		int highseasondays = 0;
		if (startdate.before(highseason_start) && startdate.before(highseason_start))
			offseasondays += daysBetween(startdate, enddate);
		else if (startdate.after(highseason_end))
			offseasondays += daysBetween(startdate, enddate);
		else if (startdate.after(highseason_start) && enddate.before(highseason_end))
			highseasondays += daysBetween(startdate, enddate);
		else if (startdate.before(highseason_start) && enddate.after(highseason_end)) {
			offseasondays += daysBetween(startdate, highseason_start);
			highseasondays += daysBetween(highseason_start, highseason_end);
			offseasondays += daysBetween(highseason_end, enddate);
		} else if (startdate.before(highseason_start) && enddate.after(highseason_start)) {
			offseasondays += daysBetween(startdate, highseason_start);
			highseasondays += daysBetween(highseason_start, enddate);
		} else if (startdate.after(highseason_start) && startdate.before(highseason_end) && enddate.after(highseason_end)) {
			offseasondays += daysBetween(startdate, highseason_end);
			highseasondays += daysBetween(highseason_end, enddate);
		}
		int[] output = {offseasondays, highseasondays};
		return output;
	}
	
	private static int daysBetween(Date d1, Date d2){
		 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	private static void writeFile(String type) {
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

	private static void filingMethod(String type, BufferedWriter bw,
			String csvType) throws IOException {
		// Writes to file corresponding to correct Class
		switch (type) {
		case "customer":
			for (Customer c : customerBase) {
				bw.write(c.getPhonenumber() + csvType);
				bw.write(c.getName() + "\n");
			}
			break;
		case "employee":
			fileEmployees(bw, csvType);
			break;
		}
	}

	private static void fileEmployees(BufferedWriter bw, String csvType)
			throws IOException {
		// Update employee database
		for (Employee e : employeeBase) {
			bw.write(e.getPhonenumber() + csvType);
			bw.write(e.getName() + csvType);
			bw.write(e.getPassword() + csvType);
			if (e instanceof CampChief)
				bw.write(2 + "\n");
			else if (e instanceof Receptionist)
				bw.write(1 + "\n");
		}
	}

	private static ArrayList<?> databaseType(String type) {
		// Determine type for arraylist depending on parameter type
		switch (type) {
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

	private static String fileType(String type) {
		// Return database path depending on parameter type
		switch (type) {
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
