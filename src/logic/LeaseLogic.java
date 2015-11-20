package logic;

import java.util.ArrayList;
import java.util.Date;

import entity.persons.Customer;
import entity.reservation.Reservation;
import entity.tenancy.Tenancy;

public class LeaseLogic {
	
	public void makeReservation(Customer customer, Date start_date, Date end_date, ArrayList<Tenancy> tenancies) {
		Reservation reservation = new Reservation(customer, end_date, end_date, tenancies);
		// save to database
	}

}
