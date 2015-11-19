package entity.reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.persons.Customer;
import entity.tenancy.Tenancy;

public class Rental extends Reservation {

	public Rental(Customer customer, Tenancy[] tenancy, Date start_date,
			Date end_date) {
		super(customer, tenancy, start_date, end_date);
	}

	
}
