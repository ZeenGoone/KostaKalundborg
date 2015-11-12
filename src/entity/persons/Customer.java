package entity.persons;

import java.util.ArrayList;

public class Customer extends Person {
	private ArrayList<Invoice> invoices;
	
	Customer (String  name, String phonenumber){
		super(name, phonenumber);
		invoices = new ArrayList<Invoice>();
	}
	
}
