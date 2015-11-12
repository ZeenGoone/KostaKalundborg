package entity.reservation;

import entity.persons.Customer;

public class Rental extends Reservation {

	
	
	// Customer customer = new Customer(name, phonenumber);
	//Tenancy
	String startDate; // in format ddmmyyyy
	String endDate;   // in format ddmmyyyy
	
	
	Rental (){
		
	}
	
	public String getStartDate () {
		return startDate;
	}
	
	public String getEndDate () {
		return endDate;
	}
	
	public void setStartDate(String startDate){
		this.startDate=startDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate=endDate;
	
	}
	
	
	
}
