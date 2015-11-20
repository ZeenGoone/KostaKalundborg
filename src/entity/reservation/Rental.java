package entity.reservation;

import java.util.ArrayList;
import java.util.Date;

import entity.persons.Customer;
import entity.tenancy.Tenancy;

public class Rental extends Reservation {

	public Rental(Customer customer, Date start_date, 
			Date end_date, ArrayList<Tenancy> tenancies) {
		super(customer, start_date, end_date, tenancies);
	}

	
}
