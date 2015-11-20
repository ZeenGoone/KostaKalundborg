package entity.persons;

import java.util.ArrayList;

public class Customer extends Person {
	private ArrayList<Invoice> invoices;
	private int currentInvoice;
	
	public Customer (String  name, String phonenumber){
		super(name, phonenumber);
		invoices = new ArrayList<Invoice>();
		currentInvoice=0;
		invoices.add(new Invoice());
	}
	public Invoice getInvoice() {
		return invoices.get(currentInvoice);
	}
	public void finishInvoice() {
		currentInvoice++;
		invoices.add(new Invoice());
	}
	
	
}
