package entity.reservation;

import entity.persons.Customer;

public class Rental extends Reservation {

	
	
	// Customer customer = new Customer(name, phonenumber);
	//Tenancy
	String startDate; // in format yyyymmdd
	String endDate;   // in format yyyymmdd
	
	
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
	
	public void checkStartDate (){
		String y = startDate.substring(0, 4);
		int year = 0;
		String m = startDate.substring(5,6);
		int month = 0;
		String d = startDate.substring(7,8);
		int day= 0;
			
		try {
				year = Integer.parseInt(y);
				
			} catch (NumberFormatException e){
				System.err.println("Wrong start year format");
				
			}
	
		try {
		
			month = Integer.parseInt(m);
			
		} catch (NumberFormatException e){
			System.err.println("Wrong start month format");
			
		}
		
		try {
			day = Integer.parseInt(d);
			
		} catch (NumberFormatException e){
			System.err.println("Wrong start day format");
			
		}
		
		if (year>1900 && year<2100){
			System.out.println("Wrong year");
				
		}
		else if (month<0 && month>12){
			System.out.println("Wrong month");
			
		}
		
		else if(day<0 && day>31){ 
			System.out.println("Wrong day");
		}
	
		else if((month == 4 ||month == 6 ||month == 9 || month ==11 )&& (day>30)) { 
			System.out.println("Wrong day");
		}
		
		else if ((month==2 && year%4 !=0 && day>28) || (month==2 && year%4==0 && day>29)){
			System.out.println("Wrong day");
		}
	}
	
}
