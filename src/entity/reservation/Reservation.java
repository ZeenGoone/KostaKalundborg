package entity.reservation;

import java.util.ArrayList;
import java.util.Date;

import entity.persons.Customer;
import entity.tenancy.Tenancy;

public class Reservation {
	public Customer customer;
	public ArrayList<Tenancy> tenancies;
	public Date start_date;
	public Date end_date;
	
	public Reservation(Customer customer, Date start_date, Date end_date){
		this.customer = customer;
		this.start_date = start_date;
		this.end_date = end_date;
		tenancies = new ArrayList<Tenancy>();
	}
}
