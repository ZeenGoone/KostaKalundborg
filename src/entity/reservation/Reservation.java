package entity.reservation;

import java.util.Date;

import entity.persons.Customer;
import entity.tenancy.Tenancy;

public abstract class Reservation {
	public Customer customer;
	public Tenancy[] tenancy;
	public Date start_date;
	public Date end_date;
	

	public Reservation(Customer customer, Tenancy[] tenancy, Date start_date, Date end_date){
		this.customer = customer;
		this.tenancy = tenancy;
		this.start_date = start_date;
		this.end_date = end_date;

	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Tenancy[] getTenancy() {
		return tenancy;
	}

	public void setTenancy(Tenancy[] tenancy) {
		this.tenancy = tenancy;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	 
	public Date getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
	
	
}
