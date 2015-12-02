package entity.persons;

import java.util.ArrayList;

public class CustomerDB {

	private ArrayList<Customer> customer = new ArrayList<Customer>();
	
	public CustomerDB() {
		
	}
	
	public void preAddedCustomer (String name, String phonenumber){
		customer.add(new Customer("Hans Hansen", "53647584"));
		customer.add(new Customer("Poul Jorgensen", "52834329"));
		customer.add(new Customer("Janne Nielsen", "12542343"));
		customer.add(new Customer ("Henning Gryn Poulsen", "98765432"));
		customer.add(new Customer("Jannick Perkele Sorensen", "03984092"));
		customer.add(new Customer("Ginny Germandsen", "02398420"));
		customer.add(new Customer("Henning Poulsen", "12121212"));
		
	}
	
	public void addCustomer (String name,  String phonenumber) {
	
		customer.add(new Customer(name, phonenumber));
		
	}
	
	
}
