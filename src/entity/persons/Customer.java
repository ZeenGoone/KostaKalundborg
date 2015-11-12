package entity.persons;

import java.util.ArrayList;

public class Customer extends Person {
	public ArrayList<Invoice> invoices;
	public int currentInvoice;
	
	public Customer (String  name, String phonenumber){
		super(name, phonenumber);
		invoices = new ArrayList<Invoice>();
		currentInvoice=0;
		invoices.add(new Invoice());
	}
	
	
}
