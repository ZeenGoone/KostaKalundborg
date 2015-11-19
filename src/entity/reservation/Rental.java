package entity.reservation;

import java.util.Date;

import entity.persons.Customer;

public class Rental extends Reservation {

	public Rental(Customer customer, Date start_date, 
			Date end_date) {
		super(customer, start_date, end_date);
	}

	
}
